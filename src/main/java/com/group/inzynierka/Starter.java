package com.group.inzynierka;

import com.group.inzynierka.domain.OtpGenerator;
import com.group.inzynierka.domain.Repository.CodeRepository;
import com.group.inzynierka.domain.Service.EmailReadService;
import com.group.inzynierka.domain.Service.EmailSendService;
import com.group.inzynierka.domain.VulnerableOtpGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    CodeRepository repo;

    @Autowired
    OtpGenerator GoodOTPGen;

    @Autowired
    VulnerableOtpGenerator BadOTPGen;

    @Autowired
    EmailSendService senderService;

    @Autowired
    EmailReadService readerService;

    @Override
    public void run(String... args) throws Exception {
        senderService.sendOTPMail();
        List<String> OTPList = readerService.receiveMail("pracainzynierska49283@gmail.com", "cbqgrkcdrcwofgvg");
        System.out.println(OTPList.toString());
    }

}
