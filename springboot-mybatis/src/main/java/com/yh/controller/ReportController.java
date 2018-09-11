package com.yh.controller;

import com.alibaba.fastjson.JSONObject;
import com.yh.entity.PushLog;
import com.yh.entity.wrap.*;
import com.yh.exception.ResultEnum;
import com.yh.exception.SystemException;
import com.yh.service.*;
import com.yh.util.Result;
import com.yh.util.ResultUtil;
import com.yh.util.SendUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Created by: LHZ
 * @Description:s
 */
@RestController
@RequestMapping("/v2/reports")
public class ReportController {

    private static final Logger log = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private BorrowListService borrowListService;

    @Autowired
    private AssessLogService assessLogService;

    @Autowired
    private SignSubjectService sss;

    @Autowired
    private EventPushService eventPushService;

    @Autowired
    private EventPushService eps;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${eventUrl}")
    private String url;

    @Value("${IMAGE.BASE.URL}")
    private String picPath;

    //成长报告：管理员可推送
    @RequestMapping("/{tchId}/{classYear}/{start}/{end}")
    @ResponseBody
    public Result getReportList(@PathVariable("classYear") Long tchId,
                                @PathVariable("classYear") Integer classYear,
                                @PathVariable("start") String start,
                                @PathVariable("end") String end,
                                //@PathVariable("pictureUrl") String pictureUrl,
                                HttpServletRequest request) throws Exception {
        List<GrowReport> grList =null;
        Set set = new HashSet();
        Long stuId = null;
        String cardNo = null;
        ItemPowerStatistics itemStatisticsList = null;
        List<SignStatistics> signList = null;
        BorrowAmount borrowAmounts = null;

        StringBuffer content = new StringBuffer();
        String templateContent = "";
        JSONObject json = new JSONObject();
        // 模板路径
        InputStream is = this.getClass().getResourceAsStream("/templates/report.html");
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        while ((templateContent=br.readLine())!=null){
            content.append(templateContent);
        }
        br.close();
        /*String filePath = Thread.currentThread().getContextClassLoader().getResource("templates/report.html").getPath();
        System.out.println(filePath);
        // 读取模板文件
        FileInputStream fis = new FileInputStream(filePath);
        int lenght = fis.available();
        byte bytes[] = new byte[lenght];
        fis.read(bytes);*/

        PushLog pushLog = null;
        try {
            String title = "";
            Byte role = (Byte) request.getSession().getAttribute("role");
            Integer startTime = Integer.valueOf(StringUtils.delete(start, "-"));
            Integer endTime = Integer.valueOf(StringUtils.delete(end, "-"));

            if(role == 0){
                Long classId = null;
                grList = eps.getCardNo();//获取基本数据
                //年级总数
                int num = eps.countStu(classYear);//全年级人数
                int awards = assessLogService.getAssessStatistics(stuId,classYear,startTime,endTime).getAward();//全年级总加分
                int deducts = assessLogService.getAssessStatistics(stuId,classYear,startTime,endTime).getDeduct();//全年级总减分
                int books = borrowListService.getBookCount(classYear, start, end);//全年级借书量
                System.out.println("总数："+books+"\t"+awards+"\t"+deducts);
                int absents = 0;
                int lates = 0;
                //classId = stuId;//将学生id赋值
                //最大分  排序
                int awardMax = assessLogService.getStudentStatistics(2, classId, startTime, endTime, classYear, new Long("1")).get(0).getAward();//最大加分
                int deductMax = assessLogService.getStudentStatistics(2, classId, startTime, endTime, classYear, new Long("2")).get(0).getDeduct();//最大扣分
                int lateMax = 0;
                int absentMax = 0;
                int bookMax = borrowListService.getBorrowAmount(null, start, end).get(0).get借书数量();
                System.out.println("最大分："+awardMax+"\t"+deductMax+"\t"+bookMax);
                //平均分
                String absentAvg = "0";//请假
                String lateAvg = "0";//迟到
                String deductAvg = "0";//加分
                String awardAvg = "0";//减分
                String bookAvg = "0";//借书
                if(num != 0){
                    absentAvg = String.format("%.2f", absents /(num * 1.0));
                    lateAvg = String.format("%.2f", lates /(num * 1.0));
                    awardAvg = String.format("%.2f", awards / (num * 1.0));
                    deductAvg = String.format("%.2f", deducts / (num * 1.0));
                    bookAvg = String.format("%.2f", books / (num * 1.0));
                }
                for (int i=0;i<grList.size();i++){
                    classId = grList.get(i).getClassId();
                    stuId = grList.get(i).getStuId();
                    String stuName = grList.get(i).getStuName();
                    cardNo = grList.get(i).getCardNo();

                    //成绩
                    int absent = 0;
                    int late = 0;
                    int book = borrowListService.getBorrowAmount(cardNo, start, end).get(0).get借书数量();
                    int award = assessLogService.getAssessStatistics(stuId,classYear,startTime,endTime).getAward();
                    int deduct = assessLogService.getAssessStatistics(stuId,classYear,startTime,endTime).getDeduct();
                    System.out.println("成绩："+book+"\t"+award+"\t"+deduct);

                    pushLog = new PushLog();
                    if(endTime - startTime <= 31){
                        title = "月度报告";
                        pushLog.setSendType(2);
                    }else {
                        title = "学期报告";
                        pushLog.setSendType(3);
                    }

                    //能量站报表
                    itemStatisticsList = assessLogService.getAssessStatistics(stuId, classYear, startTime, endTime);
                    //grList.get(i).setItemStatisticsList(itemStatisticsList);
                    System.out.println("stuName："+stuName+"，award："+itemStatisticsList.getAward());
                    //签到报表
                    Long cid = (Long) request.getSession().getAttribute("cid");
                    signList = sss.getSignStatistics(1, classId, stuId, start, end, role, cid);
                    StringBuffer sign = new StringBuffer();
                    for (int j=0;j<signList.size();j++){
                        String subName = signList.get(j).getSubName();
                        String count = String.valueOf(signList.get(j).getCount());
                        sign.append("{value: "+count+", name: '"+subName+"'},");
                    }

                    templateContent = new String(String.valueOf(content));
                    //templateContent = new String(bytes);
                    // 替换掉模板中相应的地方
                    templateContent = templateContent.replaceAll("###title###", title);
                    templateContent = templateContent.replaceAll("###stuName###", stuName);//
                    templateContent = templateContent.replaceAll("###absent###", String.valueOf(absent));//请假
                    templateContent = templateContent.replaceAll("###absentMax###", String.valueOf(absentMax));//最大请假
                    templateContent = templateContent.replaceAll("###absentAvg###", String.valueOf(absentAvg));//平均请假
                    templateContent = templateContent.replaceAll("###late###", String.valueOf(late));//迟到
                    templateContent = templateContent.replaceAll("###lateMax###", String.valueOf(lateMax));//最大迟到
                    templateContent = templateContent.replaceAll("###lateAvg###", String.valueOf(lateAvg));//平均迟到
                    templateContent = templateContent.replaceAll("###award###", String.valueOf(award));//加分
                    templateContent = templateContent.replaceAll("###awardMax###", String.valueOf(awardMax));//最大加分
                    templateContent = templateContent.replaceAll("###awardAvg###", String.valueOf(awardAvg));//平均加分
                    templateContent = templateContent.replaceAll("###deduct###", String.valueOf(deduct));//减分
                    templateContent = templateContent.replaceAll("###deductMax###", String.valueOf(deductMax));//最大减分
                    templateContent = templateContent.replaceAll("###deductAvg###", String.valueOf(deductAvg));//平均减分
                    templateContent = templateContent.replaceAll("###books###", String.valueOf(book));//借书
                    templateContent = templateContent.replaceAll("###bookMax###", String.valueOf(bookMax));//最大借书
                    templateContent = templateContent.replaceAll("###bookAvg###", String.valueOf(bookAvg));//平均借书
                    templateContent = templateContent.replaceAll("'###sign###'", String.valueOf(sign));//签到
                    //System.out.println(HtmlUtils.htmlEscape(templateContent));

                    if (templateContent != null){
                        //写入数据库
                        pushLog.setTchId(Long.valueOf(tchId));
                        pushLog.setStuId(Long.valueOf(stuId));
                        pushLog.setContent(templateContent);

                        //封装参数为json格式
                        json.put("cardNo",cardNo);
                        json.put("title","筑桥校园生活"+title);
                        json.put("pictureUrl",picPath+"notice.jpg");
                        json.put("content",HtmlUtils.htmlEscape(templateContent));
                        //发送Post数据并返回数据
                        json = SendUtil.sendPostRequest(url,json);
                        if (json.get("msg").equals("Success")){
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
            }else {
                return ResultUtil.error(ResultEnum.UNAUTHENTICATED.getCode(),"对不起，你没有此权限！");
            }
        } catch (Exception e) {
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "获取成长报告失败:" + e.getMessage());
        }
        return ResultUtil.success(json);
    }
}
