package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Order;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jms.core.JmsTemplate;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SendToJmsServiceImplTest {
    private SendToJmsService sendToJmsService;
    private JmsTemplate jmsTemplate;

    @Before
    public void setup() {
        jmsTemplate = mock(JmsTemplate.class);
        sendToJmsService = new SendToJmsServiceImpl();
        sendToJmsService.setJmsTemplate(jmsTemplate);
    }

    @Test
    public void testSendMailAlert() {
        Order order = sendToJmsService.sendMailAlert(mock(Order.class));
        verify(jmsTemplate, times(1)).convertAndSend(order);
        assertNotNull(order);
    }
}