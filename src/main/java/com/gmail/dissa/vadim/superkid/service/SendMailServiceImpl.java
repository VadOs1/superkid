package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Order;
import com.gmail.dissa.vadim.superkid.domain.Sales;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


public class SendMailServiceImpl implements SendMailService {
    private MailSender mailSender;
    private String subject;
    private String body;
    private final String[] receivers = new String[2];

    public SendMailServiceImpl() {
        receivers[0] = "vadim.dissa@gmail.com";
        receivers[1] = "natalia.dissa@gmail.com";
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    // TODO: make async
    public synchronized void sendMail(Order order, SimpleMailMessage simpleMailMessage) {
        subject = "SuperKid || New Order # " + order.getId();
        body = order.getClient().getName() + "\n\n"
                + order.getClient().getEmail() + "\n\n"
                + order.getClient().getPhone() + "\n\n";
        for (Sales sale : order.getSalesList()) {
            body += sale.getProduct().getProductCategory().getName() + " "
                    + sale.getProduct().getProductInfo().getName() + " "
                    + sale.getProduct().getProductSize().getSize() + " "
                    + sale.getProduct().getPrice() + "\n\n";
        }
        simpleMailMessage.setFrom("natalia.dissa@gmail.com");
        simpleMailMessage.setTo(receivers);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);
        mailSender.send(simpleMailMessage);
    }
}
