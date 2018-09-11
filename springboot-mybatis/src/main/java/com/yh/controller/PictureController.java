package com.yh.controller;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.yh.util.Result;
import com.yh.util.ResultUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@RestController
@RequestMapping("/v2/pics")
public class PictureController {

    @Value("${FTP.ADDRESS}")
    private String host;
    // 端口
    @Value("${FTP.PORT}")
    private int port;
    // ftp用户名
    @Value("${FTP.USERNAME}")
    private String userName;
    // ftp用户密码
    @Value("${FTP.PASSWORD}")
    private String passWord;
    // 图片在服务器端保存的主目录
    @Value("${FTP.BASEPATH}")
    private String picPath;
    //private String picPath = baseUrl + basePath;

    @RequestMapping("/list")
    public Result getPictureList() throws Exception {

        List<String> pics = new ArrayList<>();
        Channel channel = null;
        JSch jsch = new JSch();

        Session session = null;
        //从服务器上获取图片名
        try {
            // 采用指定的端口连接服务器
            session = jsch.getSession(userName, host, port);
            // 如果服务器连接不上，则抛出异常
            if (session == null) {
                throw new Exception("session is null");
            }
            // 设置登陆主机的密码
            session.setPassword(passWord); // 设置密码
            // 设置第一次登陆的时候提示，可选值：(ask | yes | no)
            session.setConfig("StrictHostKeyChecking", "no");
            // 设置登陆超时时间
            session.connect(5000);

            // 创建sftp通信通道
            channel = (Channel) session.openChannel("sftp");
            channel.connect(1000);
            ChannelSftp sftp = (ChannelSftp) channel;
            Vector<?> vector = sftp.ls(picPath);
            for (Object item : vector) {
                ChannelSftp.LsEntry entry = (ChannelSftp.LsEntry) item;
                if (entry.getFilename().length() > 4){
                    pics.add(entry.getFilename());
                }
                System.out.println(entry.getFilename());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.success(pics);
    }
}
