package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Order;
import com.gmail.dissa.vadim.superkid.domain.Sales;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@Log4j2
// TODO: replace with AWS SNS
public class SendMailServiceImpl implements SendMailService {
    private final MailSender mailSender;

    @Autowired
    public SendMailServiceImpl(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(Order order) {
        StringBuilder body = new StringBuilder(order.getClient().getName() + "\n\n"
                + order.getClient().getEmail() + "\n\n"
                + order.getClient().getPhone() + "\n\n");
        for (Sales sale : order.getSalesList()) {
            body.append(sale.getProduct().getProductCategory().getName())
                    .append(" ")
                    .append(sale.getProduct().getProductInfo().getName())
                    .append(" ").append(sale.getProduct().getProductSize().getSize())
                    .append(" ").append(sale.getProduct().getPrice())
                    .append("\n\n");
        }
        sendMail("SuperKid || New Order # " + order.getId(), body.toString());
    }

    public void sendMail(String subject, String message) {
        try {
            log.info(String.format("Sending mail. Subject: %s, message: %s", subject, message));
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo("vadim.dissa@gmail.com", "natalia.dissa@gmail.com");
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(message);
            mailSender.send(simpleMailMessage);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
