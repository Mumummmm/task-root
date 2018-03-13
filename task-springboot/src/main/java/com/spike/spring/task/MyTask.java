package com.spike.spring.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
/**
 * @author spike.lin
 */
@Component
public class MyTask {

    @Value(value = "${spring.mail.username}")
    private String from;

    @Resource
    private JavaMailSender sender;

    @Scheduled(cron = "40 06 16 * * ?")
    private void process() {
        String to = "526915701@qq.com";
        String subject = "Pi Pi Monster";
        String content = "Just pi pi";
        sendMail(to, subject, content);
    }

    public void sendMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        sender.send(message);
        System.out.println("邮件发送成功");
    }

}
