package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Order;
import com.gmail.dissa.vadim.superkid.domain.Sales;
import com.gmail.dissa.vadim.superkid.exception.SuperkidException;
import com.gmail.dissa.vadim.superkid.property.Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@Slf4j
// TODO: replace with AWS SNS
public class SendMailServiceImpl implements SendMailService {
    private final MailSender mailSender;
    private final Properties properties;
    private final Environment environment;

    @Autowired
    public SendMailServiceImpl(MailSender mailSender, Properties properties, Environment environment) {
        this.mailSender = mailSender;
        this.properties = properties;
        this.environment = environment;
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
        if (subject == null || message == null) {
            throw new SuperkidException("Subject and email should not be null.");
        }
        try {
            String subjectPrepared = subject + " " +
                    String.join(",", environment.getActiveProfiles()) + " profile/profiles active.";
            log.info(String.format("Sending mail to: %s. Subject: %s, message: %s",
                    properties.getMail().getReceivers(), subjectPrepared, message));
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(properties.getMail().getReceivers().toArray(String[]::new));
            simpleMailMessage.setSubject(subjectPrepared);
            simpleMailMessage.setText(message);
            mailSender.send(simpleMailMessage);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
