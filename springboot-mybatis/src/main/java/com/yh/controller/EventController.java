package com.yh.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yh.entity.EventLog;
import com.yh.entity.wrap.EventAssessment;
import com.yh.entity.wrap.TimeLine;
import com.yh.exception.ResultEnum;
import com.yh.exception.SystemException;
import com.yh.service.ECardLogService;
import com.yh.service.EventLogService;
import com.yh.service.RoleService;
import com.yh.util.Result;
import com.yh.util.ResultUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.text.ParseException;

/**
 * 事件中心
 * Created by HR on 2018/5/17.
 */
@RestController
@RequestMapping("/v1/event")
public class EventController {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventLogService eventLogService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ECardLogService eCardLogService;

    /**
     * @return
     * @Created by huizi Liao
     * @Description 时间轴：事件查询
     * @Param
     */
    @RequestMapping(value = "/query")
    public Object getEventLog(String date, Long classId, Long stuId, Long tchId, HttpServletRequest request) throws ParseException {

        log.info("timeLine Info..." + classId + "，" + tchId);
        //在拉取数据之前先获取用户在班级上的角色
        //0-管理员  1-班主任  2-教师  3-staff
        Byte role = (Byte) request.getSession().getAttribute("role");
        Long cid = (Long) request.getSession().getAttribute("cid");
        log.info("role:{},cid:{}", role, cid);
        List<TimeLine> eventList = eventLogService.getTimeLine(date, classId, stuId, tchId, role, cid);

        //if((role != 0) && role != 1) {
        //获取公开标签信息
        List<TimeLine> commonList = eventLogService.getCommon(date, classId, stuId);
        //将公开信息集合追加到事件记录信息集合
        if (commonList.size() != 0) {
            log.info("======日期：" + commonList.get(0).getEventDate());
            eventList.addAll(commonList);
        }
        log.info("公开信息："+commonList.size());
        //}

        //获取一卡通数据
        List<TimeLine> cardList = eventLogService.getCardLog(date, classId, stuId);

        //将一卡通事件追加到事件集合
        if (cardList.size() != 0) {
            for(int i=0;i<cardList.size();i++){
                cardList.get(i).setTagName("一卡通");
            }
            eventList.addAll(cardList);
        }
        log.info("一卡通信息："+cardList.size());

        //按照时间进行排序  ArraySort
        Collections.sort(eventList, new Comparator<TimeLine>() {
            @Override
            public int compare(TimeLine o1, TimeLine o2) {
                
                /*if((o1.getId()).compareTo(o2.getId()) == 0){
                    eventList.remove(o1);
                    log.info(o1.getId()+" "+o1.getEventTime()+" "+eventList.size());
                }*/
                return (o1.getEventTime()).compareTo(o2.getEventTime());
            }
        });

        //迭代去除重复数据
        /*Iterator<TimeLine> it = eventList.iterator();
        while(it.hasNext()){
            TimeLine o1 = it.next();
            TimeLine o2 = it.next();
            if((o1.getId()).compareTo(o2.getId()) == 0){
                it.remove();
                log.info(o1.getId()+" "+o1.getEventTime()+"  "+eventList.size());
            }
        }*/

        log.info("----------======= "+eventList.size());
        return ResultUtil.success(eventList);
    }

    @PostMapping("/log")
    //@RequiresRoles(logical = Logical.OR, value = {"r001", "r002", "r003"})
    public Result eventAssessmentLog(@RequestBody EventAssessment eventAssessment) throws ParseException {

        try {
            System.out.println(JSONObject.toJSON(eventAssessment));
            int result = eventLogService.insertEventAssessment(eventAssessment);
            if (result == 0) {
                return ResultUtil.success();
            }
        } catch (UnauthorizedException unauthorizedException) {
            log.error("当前账户缺少权限，评价or事件记录失败...");
            throw new SystemException(ResultEnum.FORBIDDEN.getCode(), "评价or事件记录失败:" + unauthorizedException.getMessage());
        } catch (Exception e) {
            log.error("评价or事件记录失败...");
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "评价or事件记录失败:" + e.getMessage());
        }
        return ResultUtil.failure();
    }

    @RequestMapping("/update")
    public Result eventUpdate(EventLog eventLog) throws ParseException {

        try {
            System.out.println(JSONObject.toJSON(eventLog));
            int result = eventLogService.updateByPrimaryKeySelective(eventLog);

            if (result >= 1) {
                return ResultUtil.success();
            }
        } catch (Exception e) {
            log.error("修改事件失败...");
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "修改事件失败:" + e.getMessage());
        }
        return ResultUtil.failure();
    }

    @RequestMapping(value = "/eCard/insert", method = RequestMethod.POST)
    public Result ECardInfoInsert(HttpServletResponse response, @RequestBody String paramStr /*String cardNo, String eventLocation, String eventNote, String eventTime*/) {

        response.setHeader("signature", "cg6dXNlBVv5b7ENcCkKJgYG5rye");
        response.setHeader("Content-Type", "application/json");

        try {
            log.info("一卡通接收参数:" + paramStr);
            String cardNo = null;
            String eventLocaiton = null;
            String eventNote = null;
            String eventTime = null;
            int result = 0;
            //JSONObject jsonStr = JSON.parseObject(String.valueOf(paramStr));
            JSONArray arr = JSONArray.parseArray(paramStr);
            System.out.println("json数组:" + arr.size());
            for (int i = 0;i < arr.size();i++){
                cardNo = (String) arr.getJSONObject(i).get("cardNo");
                eventNote = (String) arr.getJSONObject(i).get("eventNote");
                if(eventNote.equals("0")){
                    eventNote = "出校";
                }else{
                    eventNote = "进校";
                }
                eventLocaiton = (String) arr.getJSONObject(i).get("eventLocation");
                eventTime = (String) arr.getJSONObject(i).get("eventTime");
                System.out.println(arr.getJSONObject(i).toJSONString());
                result = eCardLogService.insertECardLog(cardNo,eventLocaiton,eventNote,eventTime);
            }
            if (result >= 1) {
                return ResultUtil.success();
            }
            return ResultUtil.failure();
        } catch (ParseException pe) {
            throw new SystemException(500, "日期格式不正确");
        }
    }

    //根据事件标签查询事件
    @RequestMapping("/search/{tchId}/{eventCategory}/{start}/{end}")
    public Result selectByTag(@PathVariable("tchId") Long tchId,
                              @PathVariable("eventCategory") Long eventCategory,
                              @PathVariable("start") String start,
                              @PathVariable("end") String end,
                              HttpServletRequest request) throws ParseException {
        try {
            //0-管理员  1-班主任  2-教师  3-staff
            Byte role = (Byte) request.getSession().getAttribute("role");
            Long cid = (Long) request.getSession().getAttribute("cid");
            List<TimeLine> eventCategoryList = eventLogService.selectByTag(tchId,eventCategory,start,end,role,cid);
            if (role == 1 && eventCategory != 4 && eventCategory != 5){
                List<TimeLine> otherClassList = eventLogService.selectOtherClass(tchId,eventCategory,start,end,role,cid);
                System.out.println("班主任其他班级："+otherClassList.size());
                if (otherClassList.size() != 0){
                    for (int i=0;i<otherClassList.size();i++) {
                        eventCategoryList.add(otherClassList.get(i));
                    }
                }
            }
            //按照时间进行排序
            Collections.sort(eventCategoryList, new Comparator<TimeLine>() {
                @Override
                public int compare(TimeLine o1, TimeLine o2) {
                    return (o1.getEventTime()).compareTo(o2.getEventTime());
                }
            });
            return ResultUtil.success(eventCategoryList);
        } catch (Exception e) {
            log.error("事件标签查询失败...");
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "事件标签查询失败:" + e.getMessage());
        }
    }
}
