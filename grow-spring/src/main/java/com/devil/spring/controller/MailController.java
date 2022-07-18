package com.devil.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送邮件
 *
 * @author Devil
 * @date Created in 2022/7/13 17:37
 */
@RestController
@RequestMapping(value = "/mail")
public class MailController {
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    @GetMapping("/send")
    public void send() {
//        JavaMailSenderImpl sender = new JavaMailSenderImpl();
//        sender.setHost("smtp.163.com");
//        sender.setProtocol("smtps");
//        sender.setPort(25);
//        sender.setUsername("runningwindman@163.com");
//        sender.setPassword("Zhangjing930");
//        sender.setDefaultEncoding("UTF-8");
    
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("runningwindman@163.com");
        message.setTo("562157205@qq.com");
        message.setSubject("验证码");
        message.setText("tx8867");
        // 发送邮件
//        sender.send(message);
        javaMailSender.send(message);
    }

}
