package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Order;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public interface SendMailService {
    public void setMailSender(MailSender mailSender);
    public void sendMail(Order order, SimpleMailMessage simpleMailMessage);
}
