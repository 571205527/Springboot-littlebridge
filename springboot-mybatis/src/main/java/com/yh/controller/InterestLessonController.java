package com.yh.controller;

import com.yh.entity.SignSubject;
import com.yh.entity.wrap.SignStatistics;
import com.yh.entity.wrap.SignStudentList;
import com.yh.entity.wrap.SignSubjectStu;
import com.yh.entity.wrap.TeacherSubject;
import com.yh.exception.ResultEnum;
import com.yh.exception.SystemException;
import com.yh.service.EventPushService;
import com.yh.service.SignSubjectService;
import com.yh.service.SubjectService;
import com.yh.util.Result;
import com.yh.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Created by: LHZ
 * @Description: 兴趣课：签到、报表、修改
 */
@RestController
@RequestMapping("/v2/subject")
public class InterestLessonController {

    private static final Logger log = LoggerFactory.getLogger(InterestLessonController.class);

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SignSubjectService sss;

    @Autowired
    private EventPushService eventPushService;

    //获取老师对应的兴趣课  管理员获取所有兴趣课和所有老师姓名
    @RequestMapping("/lesson/{tchId}")
    public Result getInterestLesson(@PathVariable("tchId") Long tchId, HttpServletRequest request){

        try {
            Byte role = (Byte) request.getSession().getAttribute("role");
            List<TeacherSubject> subjects = subjectService.selectBytchId(tchId, role);
            if(subjects.size() == 0 ){
                return ResultUtil.error(ResultEnum.UNAUTHENTICATED.getCode(),"对不起，你没有此权限！");
            }
            return ResultUtil.success(subjects);
        } catch (Exception e) {
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "获取兴趣课失败:" + e.getMessage());
        }
    }

    //签到
    @RequestMapping("/sign")
    public Result insertSign(SignSubjectStu record, HttpServletRequest request){

        int count = 0;
        int flag = 0;
        String name = "";
        StringBuffer stuName = new StringBuffer();
        try {
            String time = String.valueOf(System.currentTimeMillis());
            System.out.println("time=========== " + time);
            Byte role = (Byte) request.getSession().getAttribute("role");
            List<TeacherSubject> subjects = subjectService.selectBytchId(record.getTchId(), role);
            int result = 0;
            if (role == 0 || subjects.size() != 0) {
                for (int i=0;i<record.getStuIds().size();i++) {
                    log.info("count:{}", count);
                    SignSubject ss = new SignSubject();
                    ss.setClassId(record.getClassId());
                    ss.setSchId(record.getSchId());
                    ss.setSubId(record.getSubId());
                    ss.setStuId(record.getStuIds().get(i));
                    ss.setTchId(record.getTchId());
                    ss.setSignTime(record.getSignTime());
                    result = sss.insertDistinct(ss);
                    if (result == 0) {
                        name = eventPushService.selectById(record.getStuIds().get(i)).getStuNickname();
                        flag++;
                        stuName.append(name+"、");
                    }
                }
                if (stuName.length() != 0) {
                    name = stuName.substring(0, stuName.length() - 1);
                }
                count = sss.getCountSign(record.getSubId(), record.getTchId());
                System.out.println("name:"+name+"，flag:"+flag+"，count"+count);
            } else {
                return ResultUtil.error(ResultEnum.UNAUTHENTICATED.getCode(), "对不起，你没有此权限！");
            }
        } catch (Exception e) {
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "兴趣课签到失败:" + e.getMessage());
        }
        if (flag != 0){
            return ResultUtil.failure(ResultEnum.FAILURE.getCode(), String.valueOf(name),count);
        }else {
            return ResultUtil.success(count);
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

    //获取签到名单
    @RequestMapping("/list/{subId}/{tchId}/{date}")
    public Result getSignStudent(@PathVariable("subId") Long subId,
                                 @PathVariable("tchId") Long tchId,
                                 @PathVariable("date") String date,
                                 HttpServletRequest request){
        try {
            Byte role = (Byte) request.getSession().getAttribute("role");
            log.info("role："+role);
            List<SignStudentList> studentLists = sss.getSignStudent(subId,tchId,date,role);

            return ResultUtil.success(studentLists);
        } catch (Exception e) {
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "签到名单获取失败:" + e.getMessage());
        }
    }

    //签到修改
    @RequestMapping("/modify")
    public Result updateSign(SignSubject record){
        try {
            //Byte role = (Byte) request.getSession().getAttribute("role");
            record.setStatus(new Byte("1"));
            int result = sss.updateByPrimaryKeySelective(record);

            if(result>=1){
                return ResultUtil.success();
            }
        } catch (Exception e) {
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "兴趣课签到修改失败:" + e.getMessage());
        }
        return ResultUtil.failure();
    }

    //签到报表 班主任 管理员
    //module:1-学生  2-班级
    @RequestMapping("/chart/{module}/{classId}/{stuId}/{start}/{end}")
    public Result signStatistics(@PathVariable("module") Integer module,
                                 @PathVariable("classId") Long classId,
                                 @PathVariable("stuId") Long stuId,
                                 @PathVariable("start") String start,
                                 @PathVariable("end") String end,
                                 HttpServletRequest request){
        try {
            Byte role = (Byte) request.getSession().getAttribute("role");
            Long cid = (Long) request.getSession().getAttribute("cid");
            System.out.println("role："+role+" cid："+cid +classId);
            List<SignStatistics> signList = null;
            if (role == 1 && !cid.equals(classId)){
                return ResultUtil.success();
            }else {
                signList = sss.getSignStatistics(module, classId, stuId, start, end, role, cid);
                return ResultUtil.success(signList);
            }
        } catch (Exception e) {
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "兴趣课签到报表查询失败:" + e.getMessage());
        }
    }

    //老师  管理员
    @RequestMapping("/chart/{tchId}/{subId}/{start}/{end}")
    public Result subStatistics(@PathVariable("tchId") Long tchId,
                                @PathVariable("subId") Long subId,
                                @PathVariable("start") String start,
                                @PathVariable("end") String end,
                                HttpServletRequest request){
        try {
            Byte role = (Byte) request.getSession().getAttribute("role");
            List<TeacherSubject> subjects = subjectService.selectBytchId(tchId, role);
            if (subjects.size() != 0) {
                List<SignStatistics> signList = sss.getSubStatistics(tchId, subId, start, end, role);
                return ResultUtil.success(signList);
            }else {
                return ResultUtil.error(ResultEnum.UNAUTHENTICATED.getCode(),"对不起，你不是兴趣课老师！");
            }
        }catch (Exception e){
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "兴趣课签到报表查询失败:" + e.getMessage());
        }
        //return ResultUtil.failure();
    }
}
