package com.raf.sk.newE;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raf.sk.domain.Mail;
import com.raf.sk.domain.MailType;
import com.raf.sk.repository.MailRepository;
import com.raf.sk.repository.TypeRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    private MailRepository mailRepository;
    private TypeRepository typeRepository;



    public void sendMail(String to, String subject, String text, Long messageType, String recipientEmail){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

//        MailType mailType = typeRepository.findById(messageType).orElse(null);
//        if(mailType==null){
//            return;
//        }
        Mail mail = new Mail();
        mail.setEmail(to);
//        mail.setMailType(mailType);
        mail.setContent(text);
        mail.setTimeofsending(java.time.LocalDate.now());
        mail.setRecieverMail(recipientEmail);


        mailSender.send(message);
        mailRepository.save(mail);
    }


}
