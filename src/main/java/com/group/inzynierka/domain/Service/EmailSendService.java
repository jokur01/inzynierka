package com.group.inzynierka.domain.Service;

import com.group.inzynierka.domain.OtpGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    OtpGenerator GoodOTPGen;

    public void sendEmail(String toEMail, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("pracainzynierska49283@gmail.com");
        message.setTo(toEMail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Mail sent successfully");

    }

    //@EventListener(ApplicationReadyEvent.class)
    public void sendOTPMail(){
        int howMany = 2;
        for(int i = 0; i<howMany; i++){
            String otp = GoodOTPGen.generateCode();
            sendEmail("pracainzynierska49283@gmail.com", "OTP" + i, otp);
        }
    }
}
