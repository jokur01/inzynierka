package com.group.inzynierka;

import com.group.inzynierka.domain.Service.EmailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InzynierkaApplication {

	@Autowired
	private EmailSendService senderService;

	public static void main(String[] args) {
		SpringApplication.run(InzynierkaApplication.class, args);
	}
//	@EventListener(ApplicationReadyEvent.class)
//	public void sendMail(){
//		for(int i= 0; i<1; i++) {
//			senderService.sendEmail("pracainzynierska49283@gmail.com", "Subject", "This is body");
//		}
//	}
}
