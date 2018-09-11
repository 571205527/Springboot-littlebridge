package com.yh.controller;

import com.yh.entity.AssessLog;
import com.yh.entity.wrap.*;
import com.yh.exception.ResultEnum;
import com.yh.exception.SystemException;
import com.yh.service.AssessLogService;
import com.yh.util.Result;
import com.yh.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by HR on 2018/5/17.
 */
@RestController
@RequestMapping("/v1/assess")
public class AssessmentController {

    private static final Logger log = LoggerFactory.getLogger(AssessmentController.class);

    @Autowired
    private AssessLogService assessLogService;

    //module：1-stu 2-class 3-grade
    @RequestMapping(value = "/assessLog/{schId}/{tchId}/{module}/{start}/{end}/{stuOrClassId}/{classYear}", method = RequestMethod.GET)
    public Result getAssessLogByModule(@PathVariable("schId") Long schId,
                                       @PathVariable("tchId") Long tchId,
                                       @PathVariable("module") Integer module,
                                       @PathVariable("start") String start,
                                       @PathVariable("end") String end,
                                       @PathVariable("stuOrClassId") Long stuOrClassId,
                                       @PathVariable("classYear") Integer classYear,
                                       HttpServletRequest request) {

        try {
            Integer startTime = Integer.valueOf(StringUtils.delete(start, "-"));
            Integer endTime = Integer.valueOf(StringUtils.delete(end, "-"));

            Byte role = (Byte) request.getSession().getAttribute("role");
            Long cid = (Long) request.getSession().getAttribute("cid");
            log.info("role:{},cid:{}", role, cid);

            List<ItemPowerStatistics> itemStatisticsList = assessLogService.getAssessLogStatistics(module, schId, tchId, stuOrClassId, startTime, endTime, classYear, role, cid);

            return ResultUtil.success(itemStatisticsList);
        } catch (Exception e) {
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "查询能量站报表错误：" + e.getMessage());
        }
    }

    @RequestMapping(value = "/assessLog/{schId}/{tchId}/{module}/{start}/{end}/{stuOrClassId}/{classYear}/{unit}/time", method = RequestMethod.GET)
    public Result getAssessLogByModuleAndTime(@PathVariable("module") Integer module,
                                              @PathVariable("schId") Long schId,
                                              @PathVariable("tchId") Long tchId,
                                              @PathVariable("start") String start,
                                              @PathVariable("end") String end,
                                              @PathVariable("stuOrClassId") Long stuOrClassId,
                                              @PathVariable("classYear") Integer classYear,
                                              @PathVariable("unit") Integer unit,
                                              HttpServletRequest request) {

        try {

            Integer startTime = Integer.valueOf(StringUtils.delete(start, "-"));
            Integer endTime = Integer.valueOf(StringUtils.delete(end, "-"));

            Byte role = (Byte) request.getSession().getAttribute("role");
            Long cid = (Long) request.getSession().getAttribute("cid");
            log.info("role:{},cid:{}", role, cid);

            List<String> dates = null;
            if (unit == 1){
                dates = getDates(start, end);
            }else if (unit ==2){
                dates = getWeeks(start, end);
            }else if (unit == 3){
                dates = getMonth(start, end);
            }

            if (dates.size() > 60){
                return ResultUtil.error(ResultEnum.FORBIDDEN.getCode(), "返回结果超额");
            }

            List<ItemTimeStatistics> itemTimeStatisticsList = assessLogService.geAssessLogTimeStatistics(module, schId, tchId, stuOrClassId, startTime, endTime, classYear, unit, role, cid);

            ItemTimeStatisticsFollowTime itemTimeStatisticsFollowTime = new ItemTimeStatisticsFollowTime();
//            itemTimeStatisticsFollowTime.setAward(0);
//            itemTimeStatisticsFollowTime.setDeduct(0);
            itemTimeStatisticsFollowTime.setTotal(0);
            List<ItemTimeStatisticsFollowTime> itemTimeStatisticsFollowTimeList = new ArrayList<>();
            itemTimeStatisticsFollowTimeList.add(itemTimeStatisticsFollowTime);


            for (ItemTimeStatistics itemTimeStatistics : itemTimeStatisticsList) {
                List<String> timeEntity = new ArrayList<>();
                for (ItemStatistics itemStatistics : itemTimeStatistics.getItemStatisticsList()) {
                    timeEntity.add(itemStatistics.getTime());
                }

                for (String date : dates) {
                    if (timeEntity.contains(date)) {
                        continue;
                    }

                    ItemStatistics itemStatisticsEntity = new ItemStatistics();
                    itemStatisticsEntity.setItemTimeStatisticsFollowTimes(itemTimeStatisticsFollowTimeList);

                    itemStatisticsEntity.setTime(date);
                    itemTimeStatistics.getItemStatisticsList().add(itemStatisticsEntity);
                }
                Collections.sort(itemTimeStatistics.getItemStatisticsList(), new Comparator<ItemStatistics>(){

                    @Override
                    public int compare(ItemStatistics o1, ItemStatistics o2) {
                        if (o1.getTime() == null || o2.getTime() == null){
                            return 0;
                        }
                        return o1.getTime().compareTo(o2.getTime());
                    }
                });
                itemTimeStatistics.getItemStatisticsList();
            }

            return ResultUtil.success(itemTimeStatisticsList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "查询能量条报表错误：" + e.getMessage());
        }
    }

    List<String> getDates(String start, String end) throws ParseException {

        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start);//定义起始日期
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);

        ArrayList dates = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        Date tmpDate = calendar.getTime();
        long endTime = endDate.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        while (tmpDate.before(endDate) || tmpDate.getTime() == endTime) {
            dates.add(sdf.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            tmpDate = calendar.getTime();
        }
        return dates;
    }

    public List<String> getWeeks(String start, String end) throws ParseException {

        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start);//定义起始日期
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);

        ArrayList dates = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        Date tmpDate = calendar.getTime();
        long endTime = endDate.getTime();
        while (tmpDate.before(endDate) || tmpDate.getTime() == endTime) {
            dates.add(calendar.get(Calendar.YEAR) + "第" + calendar.get(Calendar.WEEK_OF_YEAR) + "周");
            calendar.add(Calendar.WEEK_OF_YEAR, 1);
            tmpDate = calendar.getTime();
        }
        return dates;
    }

    public List<String> getMonth(String start, String end) throws ParseException {

        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start);//定义起始日期
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);

        ArrayList dates = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        Date tmpDate = calendar.getTime();
        long endTime = endDate.getTime();
        while (tmpDate.before(endDate) || tmpDate.getTime() == endTime) {
            if (calendar.get(Calendar.MONTH) < 9){
                dates.add(calendar.get(Calendar.YEAR) + "第" + 0 + (calendar.get(Calendar.MONTH) + 1) + "月");
            }else {
                dates.add(calendar.get(Calendar.YEAR) + "第" + (calendar.get(Calendar.MONTH) + 1) + "月");
            }
            calendar.add(Calendar.MONTH, 1);
            tmpDate = calendar.getTime();
        }
        return dates;
    }

    //学生排序  1：在班级上的排序   2：在年级上的排序    3：个人
    @RequestMapping("/stuRank/{module}/{classId}/{classYear}/{start}/{end}/{order}")
    public Result getStudentRank(@PathVariable("classId") Long classId,
                                 @PathVariable("module") Integer module,
                                 @PathVariable("start") String start,
                                 @PathVariable("end") String end,
                                 @PathVariable("classYear") Integer classYear,
                                 @PathVariable("order") Long order) {
        try {

            Integer startTime = Integer.valueOf(StringUtils.delete(start, "-"));
            Integer endTime = Integer.valueOf(StringUtils.delete(end, "-"));

            List<StudentStatistics> stuRankList = assessLogService.getStudentStatistics(module, classId, startTime, endTime, classYear, order);
            return ResultUtil.success(stuRankList);
        } catch (Exception e) {
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "学生排行榜错误：" + e.getMessage());
        }
    }

    @RequestMapping("/classRank/{classYear}/{start}/{end}/{order}")
    public Result getClassRank(@PathVariable("start") String start,
                               @PathVariable("end") String end,
                               @PathVariable("classYear") Integer classYear,
                               @PathVariable("order") Long order) {
        try {
            Integer startTime = Integer.valueOf(StringUtils.delete(start, "-"));
            Integer endTime = Integer.valueOf(StringUtils.delete(end, "-"));

            List<StudentStatistics> classRankList = assessLogService.getClassStatistics(startTime, endTime, classYear, order);
            return ResultUtil.success(classRankList);
        } catch (Exception e) {
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "班级排行榜错误：" + e.getMessage());
        }
    }

    //查看某一天某班级的评价流水   role:2、3 看自己的评价流水  0 看所有流水  1  看本班所有流水
    //module 1:按学生查看流水 2：按班级查看流水
    @RequestMapping("/flow/{module}/{tchId}/{classId}/{stuId}/{date}")
    public Result getAssessFlow(@PathVariable("module") Integer module,
                                @PathVariable("tchId") Long tchId,
                                @PathVariable("classId") Integer classId,
                                @PathVariable("stuId") Integer stuId,
                                @PathVariable("date") String date,
                                HttpServletRequest request) {
        try {

            Byte role = (Byte) request.getSession().getAttribute("role");
            Long cid = (Long) request.getSession().getAttribute("cid");
            System.out.println("role："+role+" cid:"+cid);

            //评价记录
            List<AssessFlow> assessLogList = assessLogService.getAssessLogBytchId(module, tchId, classId, stuId, date, role, cid);
            log.info("评价记录： "+assessLogList.size());
            //有事件的评价记录
            List<AssessFlow> eventLogList = assessLogService.getEventLogByAssessId(module, tchId, classId, stuId, date);
            log.info("有事件的评价记录： "+eventLogList.size());

            if (eventLogList.size() != 0){
                for(int i=0;i<assessLogList.size();i++){
                    for(int j=0;j<eventLogList.size();j++){
                        if((eventLogList.get(j).getId()).equals(assessLogList.get(i).getId())){
                            assessLogList.get(i).setEventLocation(eventLogList.get(j).getEventLocation());
                            assessLogList.get(i).setEventNote(eventLogList.get(j).getEventNote());
                            //log.info("============ "+assessLogList.get(i).getId());
                        }
                    }
                }
            }
            return ResultUtil.success(assessLogList);
        } catch (Exception e) {
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "查看评价流水错误：" + e.getMessage());
        }
    }

    @RequestMapping("/cancel/{id}")
    public Result cancelAssess(@PathVariable("id") Long id){
        try {
            AssessLog log = new AssessLog();
            log.setId(id);
            log.setStatus(new Byte("1"));
            int result=assessLogService.updateByPrimaryKeySelective(log);
            if (result >=1){
                return ResultUtil.success();
            }
        } catch (Exception e) {
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "个人评价撤销失败：" + e.getMessage());
        }
        return ResultUtil.failure();
    }
}
