package com.raf.sk.listener;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raf.sk.dto.AdditionDto;
import com.raf.sk.listener.helper.MessageHelper;
import com.raf.sk.listener.helper.NotificationMQ;
import com.raf.sk.newE.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import javax.jms.JMSException;
import javax.jms.Message;

@Component
@AllArgsConstructor
public class EmailListener {

    private MessageHelper messageHelper;
    private EmailService emailService;
    ObjectMapper objectMapper;



    @JmsListener(destination = "${async.sendEmails}", concurrency = "5-10")
    public void register(Message message) throws JMSException {
        NotificationMQ<?> notificationMQ = messageHelper.getMessage(message, NotificationMQ.class);
        AdditionDto additionDto = objectMapper.convertValue(notificationMQ.getData(), AdditionDto.class);
        emailService.sendMail(additionDto.getEmail(), "Welcome to Workout Station", "Hello user : " + additionDto.getName() + "\n ako si mislio da ces morati da kliknes neki link, nema toga ovdje preposteni/a moj", 1L, additionDto.getEmail());
    }

//    @JmsListener(destination = "changepassword", concurrency = "5-10")
//    public void changePassword(Message message) throws JMSException {
//        ChangePasswordNotification registerNotification = messageHelper.getMessage(message, ChangePasswordNotification.class);
//        emailService.sendSimpleMessage(registerNotification.getEmail(), "Confirm password change", registerNotification.toString(), 2L, registerNotification.getReceiverId());
//    }
//
//    @JmsListener(destination = "reminder", concurrency = "5-10")
//    public void reservationReminder(Message message) throws JMSException{
//        ReservationReminderNotification reservationReminderNotification = messageHelper.getMessage(message, ReservationReminderNotification.class);
//        emailService.sendSimpleMessage(reservationReminderNotification.getEmail(), "Reservation reminder", reservationReminderNotification.toString(), 3L, reservationReminderNotification.getReceiverId());
//    }

}
