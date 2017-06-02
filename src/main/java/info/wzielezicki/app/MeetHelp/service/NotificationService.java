package info.wzielezicki.app.MeetHelp.service;

import info.wzielezicki.app.MeetHelp.model.Participant;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by wzielezi on 2017-06-02.
 */

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(String mail, String eventTitle, String message) throws MailException{
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail);
        mailMessage.setFrom("meethelp@gmail.com");
        mailMessage.setSubject("MeetHelp, informacja na temat spotkania " + eventTitle );
        mailMessage.setText(message);

        javaMailSender.send(mailMessage);
    }
}
