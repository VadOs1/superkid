package com.gmail.dissa.vadim.superkid.service;


import com.gmail.dissa.vadim.superkid.domain.Order;
import org.springframework.jms.core.JmsTemplate;

public interface SendToJmsService {
    public void setJmsTemplate(JmsTemplate jmsTemplate);
    public Order sendMailAlert(Order order);
}
