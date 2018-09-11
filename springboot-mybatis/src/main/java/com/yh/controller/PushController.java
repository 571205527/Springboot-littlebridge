package com.yh.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yh.entity.PushLog;
import com.yh.exception.ResultEnum;
import com.yh.exception.SystemException;
import com.yh.service.EventPushService;
import com.yh.util.Result;
import com.yh.util.ResultUtil;
import com.yh.util.SendUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.HtmlUtils;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Created by: LHZ
 * @Description: 事件推送页面的格式化
 */
@RestController
public class PushController {

    @Autowired
    private EventPushService eventPushService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${eventUrl}")
    private String url;

    @Value("${IMAGE.BASE.URL}")
    private String picPath;

    @PostMapping("/v2/push/send")
    public Result eventPush(@RequestBody String paramStr) throws Exception {

        StringBuffer content = new StringBuffer();
        String templateContent = "";
        JSONObject json = new JSONObject();
        Set set = new HashSet();
        // 模板路径
        InputStream is = this.getClass().getResourceAsStream("/templates/event.html");//Thread.currentThread().getContextClassLoader().getResource("templates/event.html").getPath();
        //Properties props = new Properties();
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        while ((templateContent=br.readLine())!=null){
            content.append(templateContent);
        }
        br.close();
        // 读取模板文件
        /*FileInputStream fis = new FileInputStream(filePath);
        int length = fis.available();
        byte bytes[] = new byte[length];
        fis.read(bytes);*/
        try {
            JSONObject jsonStr = JSON.parseObject(String.valueOf(paramStr));

            String title = "筑桥点滴";
            String stuName = "";
            String cardNo = null;
            Integer tchId = (Integer) jsonStr.get("tchId");
            System.out.println("tchId："+tchId);
            String tchName = eventPushService.selectByPrimaryKey(Long.valueOf(tchId)).getTchName();//教师
            String eventLocation = ((String) jsonStr.get("eventLocation"));//事件地点
            String eventNote = (String) jsonStr.get("eventNote");//事件内容
            String eventTime = (String) jsonStr.get("eventTime");//事件时间
            String pictureUrl = (String) jsonStr.get("pictureUrl");//图片路径

            for (int i = 0; i < jsonStr.getJSONArray("stuIds").size(); i++) {
                Integer stuId = (Integer) jsonStr.getJSONArray("stuIds").get(i);//Integer cannot be to Long
                //System.out.println("stuId："+stuId);
                cardNo = eventPushService.getCardNoByStuId(Long.valueOf(stuId)).getCardNo();
                stuName = eventPushService.getCardNoByStuId(Long.valueOf(stuId)).getStuName();

                templateContent = new String(String.valueOf(content));
                // 替换掉模板中相应的地方
                templateContent = templateContent.replaceAll("###cardNo###", cardNo);//卡号
                templateContent = templateContent.replaceAll("###stuName###", stuName);//学生
                templateContent = templateContent.replaceAll("###tchName###", tchName);//教师
                templateContent = templateContent.replaceAll("###eventLocation###", eventLocation);//地点
                templateContent = templateContent.replaceAll("###eventNote###", eventNote);//内容
                templateContent = templateContent.replaceAll("###eventTime###", eventTime);//时间
                //System.out.println(HtmlUtils.htmlEscape(templateContent));

                if (templateContent != null) {

                    //写入数据库
                    PushLog pushLog = new PushLog();
                    pushLog.setSendType(1);
                    pushLog.setTchId(Long.valueOf(tchId));
                    pushLog.setStuId(Long.valueOf(stuId));
                    pushLog.setContent(templateContent);
                    //封装参数为json格式
                    json.put("cardNo",cardNo);
                    json.put("title",title);
                    json.put("pictureUrl",picPath+ pictureUrl);
                    json.put("content",HtmlUtils.htmlEscape(templateContent));

                    //发送Post数据并返回数据
                    json = SendUtil.sendPostRequest(url,json);
                    System.out.println(json.get("msg"));
                    if (json.equals("Success")){
                        //return ResultUtil.success(json);
                    }else{
                        set.add(json);
                        pushLog.setIsSend(new Byte("1"));
                        System.out.println("集合："+set.size());
                    }
                    int result = eventPushService.insertSelective(pushLog);
                    System.out.println("推送记录："+result);
                }
            }
        } catch (Exception e) {
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "推送事件失败:" + e.getMessage());
        }
        return ResultUtil.success(json);
        /*if (set.size()==0){
            return ResultUtil.success(json);
        }else {
            return ResultUtil.failure();
        }*/
    }
}
