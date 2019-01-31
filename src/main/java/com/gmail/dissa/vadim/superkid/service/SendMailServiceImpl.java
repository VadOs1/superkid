package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Order;
import com.gmail.dissa.vadim.superkid.domain.Sales;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl implements SendMailService {
    private final Logger logger = Logger.getLogger(SendMailServiceImpl.class);
    private final MailSender mailSender;

    @Autowired
    public SendMailServiceImpl(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(Order order) {
        try {
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
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(new String[]{"vadim.dissa@gmail.com", "natalia.dissa@gmail.com"});
            simpleMailMessage.setSubject("SuperKid || New Order # " + order.getId());
            simpleMailMessage.setText(body.toString());
            mailSender.send(simpleMailMessage);
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
