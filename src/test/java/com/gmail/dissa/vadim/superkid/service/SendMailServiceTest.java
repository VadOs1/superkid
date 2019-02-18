package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Client;
import com.gmail.dissa.vadim.superkid.domain.Order;
import com.gmail.dissa.vadim.superkid.domain.OrderStatus;
import org.junit.Before;
import org.junit.Test;
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
        sendMailService = new SendMailServiceImpl(mailSender);
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