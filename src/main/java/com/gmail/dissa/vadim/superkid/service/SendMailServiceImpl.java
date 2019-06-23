package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Order;
import com.gmail.dissa.vadim.superkid.domain.Sales;
import com.gmail.dissa.vadim.superkid.property.Properties;
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
    private Properties properties;

    @Autowired
    public SendMailServiceImpl(MailSender mailSender, Properties properties) {
        this.mailSender = mailSender;
        this.properties = properties;
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
            log.info(String.format("Sending mail to: %s. Subject: %s, message: %s",
                    properties.getMail().getReceivers(), subject, message));
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(properties.getMail().getReceivers().toArray(String[]::new));
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(message);
            mailSender.send(simpleMailMessage);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
