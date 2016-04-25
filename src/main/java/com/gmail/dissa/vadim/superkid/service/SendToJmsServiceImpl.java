package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendToJmsServiceImpl implements SendToJmsService {

    private JmsTemplate jmsTemplate;

    public SendToJmsServiceImpl() {
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
    }

    @Autowired
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public Order sendMailAlert(final Order order) {
        jmsTemplate.convertAndSend(order);
        return order;
    }
}
