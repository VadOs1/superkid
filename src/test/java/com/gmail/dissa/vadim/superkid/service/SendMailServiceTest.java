package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Client;
import com.gmail.dissa.vadim.superkid.domain.Order;
import com.gmail.dissa.vadim.superkid.domain.OrderStatus;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.*;

public class SendMailServiceTest {

    private SendMailService sendMailService;
    private MailSender mailSender;
    private SimpleMailMessage simpleMailMessage;
    private Order order;

    @Before
    public void setup() {
        mailSender = mock(MailSender.class);
        simpleMailMessage = mock(SimpleMailMessage.class);
        order = new Order(new Date(), mock(OrderStatus.class), mock(Client.class), new String(), new String(), new String());
        order.setSalesList(new ArrayList<>());
        sendMailService = new SendMailServiceImpl();
        sendMailService.setMailSender(mailSender);
    }

    @Test
    public void testSendMail(){
        sendMailService.sendMail(order, simpleMailMessage);
        verify(mailSender, times(1)).send(simpleMailMessage);
    }
}
