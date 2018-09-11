package com.yh.controller;

import com.yh.entity.Class;
import com.yh.entity.Privilege;
import com.yh.entity.Teacher;
import com.yh.entity.wrap.*;
import com.yh.exception.ResultEnum;
import com.yh.service.ClassService;
import com.yh.service.SubjectService;
import com.yh.service.TeacherService;
import com.yh.service.UserService;
import com.yh.util.BaseUtil;
import com.yh.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by HR on 2018/5/4.
 */

@RestController
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "login";
    }

    /**
     * 未登录，shiro应重定向到登录界面，前后端分离，此处返回未登录状态信息由前端控制跳转页面
     *
     * @return
     */
    @RequestMapping(value = "/unAuth")
    public Object unAuth() {
        Map<String, Object> map = new HashMap();
        map.put("code", "403");
        map.put("msg", "未登录");
        return map;
    }

    @Autowired
    private ClassService classService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserService userService;

    @Autowired
    private SubjectService subjectService;

    //登陆验明真身
    @RequestMapping("/check")
    public Object getUserType(String username,HttpSession session){
        try {
            Byte result = userService.findByUserName(username).getUserType();
            String userType = null;
            List<Class> classList = null;
            if(result == 1){
                userType = "班主任";
                classList = classService.getAllClass();
            }
            return ResultUtil.success(classList);
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),"无效用户名！");
        }
    }

    //登陆 获取基本信息
    @RequestMapping(value = "/clientLogin", method = RequestMethod.POST)
    public Object login(String username, String password,Long cid, HttpSession session) {

        log.info("login start:username-->{}, password-->{},classId-->{}, userType-->{}", username, password, cid);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            session.setAttribute("cid",cid);

            log.info("cid:{}",cid);
            log.info("login end !!!");

            Map<String, Object> loginInfo = new HashMap();

            Teacher teacher = teacherService.getTeacherByUsername(username);

            if (teacher.getSchId() == null) {
                return ResultUtil.success();
            }

            Long tchId = teacher.getId();
            Byte result = userService.findByUserName(username).getUserType();
            List<TeacherSubject> subjects = subjectService.selectBytchId(tchId, result);
            log.info("兴趣课：{}",subjects.size());
            SignPrivilege sp = new SignPrivilege();
            //班主任降级处理
            if(cid == null && result == 1) {
                sp.setRole(new Byte("2"));
                session.setAttribute("role",sp.getRole());
            }else {
                sp.setRole(result); //角色
                session.setAttribute("role",result);
                log.info("userType：{}",result);
            }
            if(subjects.size() == 0 || result >= 3) {
                sp.setState(1);//签到权限：1 无权限  0 有权限
                sp.setComment("没有签到权限！！");
            }else{
                sp.setState(0);
            }
            loginInfo.put("privilege",sp);

            List<GradeClassStudents> classStudents = classService.getClassStudents(teacher.getSchId());
            loginInfo.put("teacher", teacher);

            if (classStudents.size() < 1) {
                return ResultUtil.success(loginInfo);
            }

            loginInfo.put("classStudent", classStudents);
            List<Grade> grades = new ArrayList<>();

            int status = 0;
            for (GradeClassStudents classStudent : classStudents) {
                for (Grade grade : grades) {
                    if (grade.getCreateDt().equals(classStudent.getGrade())) {
                        status = 1;
                    }
                }
                if (status == 1) {
                    status = 0;
                    continue;
                }
                Grade gradeNew = new Grade();
                gradeNew.setCreateDt(Integer.valueOf(classStudent.getGrade()));
                Integer gradeNo = BaseUtil.gradeToChinese(Integer.valueOf(classStudent.getGrade()));
                gradeNew.setGradeId(gradeNo);
                gradeNew.setGradeName(BaseUtil.CHINESE.get(gradeNo) + "年级 Grade "+ gradeNo);

                grades.add(gradeNew);
            }
            loginInfo.put("grades", grades);

            return ResultUtil.success(loginInfo);
        } catch (IncorrectCredentialsException e) {
            return ResultUtil.error(4, "Incorrect Password");
        } catch (LockedAccountException e) {
            return ResultUtil.error(5, "Locked Account");
        } catch (AuthenticationException e) {
            return ResultUtil.error(6, "Account Not Exist");
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.INTERNAL_SERVER_ERROR.getCode(),ResultEnum.INTERNAL_SERVER_ERROR.getMsg() + e.getMessage());
        }
    }
}
