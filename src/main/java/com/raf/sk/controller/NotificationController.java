package com.raf.sk.controller;

import com.raf.sk.newE.EmailService;
import com.raf.sk.repository.MailRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
@AllArgsConstructor
public class NotificationController {

    EmailService emailService;
    MailRepository mailRepository;

    @PostMapping("/send")
    private void posalji(){
        emailService.sendMail("djoncic14122rn@raf.rs","Pozdrav","Cao",null,"djoncic14122rn@raf.rs");
    }

}
