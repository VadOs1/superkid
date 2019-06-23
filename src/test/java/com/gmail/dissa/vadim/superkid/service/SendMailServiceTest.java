package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Client;
import com.gmail.dissa.vadim.superkid.domain.Order;
import com.gmail.dissa.vadim.superkid.domain.OrderStatus;
import com.gmail.dissa.vadim.superkid.property.Mail;
import com.gmail.dissa.vadim.superkid.property.Properties;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class SendMailServiceTest {

    private SendMailService sendMailService;
    private MailSender mailSender;
    private Order order;

    @Before
    public void setup() {
        mailSender = mock(JavaMailSenderImpl.class);
        Properties properties = new Properties();
        Mail mail = new Mail();
        mail.setReceivers(new ArrayList<>());
        properties.setMail(mail);

        Environment environment = mock(Environment.class);
        when(environment.getActiveProfiles()).thenReturn(new String[0]);

        sendMailService = new SendMailServiceImpl(mailSender, properties, environment);
        order = new Order(new Date(), mock(OrderStatus.class),
                mock(Client.class), "", "", "");
        order.setSalesList(new ArrayList<>());
    }

    @Test
    public void testSendMail() {
        sendMailService.sendMail(order);
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }
}