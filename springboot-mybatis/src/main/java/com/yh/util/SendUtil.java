package com.yh.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @Created by: LHZ
 * @Description:
 */
public class SendUtil {
    /**
     * 向目的URL发送post请求
     * @param url       目的url
     * @param params    发送的参数
     * @return  JSONObject
     */
    private final static String signature = "402814815a61209d015a612db5c70000";
    public static JSONObject sendPostRequest(String url, JSONObject params){

        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpMethod method = HttpMethod.POST;
        //MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        //headers.setContentType(type);

        headers.setContentType(MediaType.APPLICATION_JSON) ;
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("signature",signature);

        //将请求头和参数合成一个请求
        HttpEntity<JSONObject> requestEntity = new HttpEntity<>(params, headers);
        //执行HTTP请求，将返回的结构使用Result类格式化
        ResponseEntity<JSONObject> response = client.postForEntity(url, requestEntity, JSONObject.class);
        System.out.println("json========："+response.getBody());
        return response.getBody();
    }
}