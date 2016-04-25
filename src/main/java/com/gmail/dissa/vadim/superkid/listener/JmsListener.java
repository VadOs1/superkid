package com.gmail.dissa.vadim.superkid.listener;


import com.gmail.dissa.vadim.superkid.domain.Order;
import com.gmail.dissa.vadim.superkid.service.SendMailService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class JmsListener implements MessageListener {
    private Logger logger;
    SendMailService sendMailService;

    public JmsListener(){
        logger = Logger.getLogger(JmsListener.class);
    }

    public JmsListener(Logger logger){
        this.logger = logger;
    }

    @Autowired
    public void setSendMailService(SendMailService sendMailService) {
        this.sendMailService = sendMailService;
    }

    @Override
    public synchronized void onMessage(Message message) {
        try {
            Order order = (Order) ((ObjectMessage) message).getObject();
            sendMailService.sendMail(order, new SimpleMailMessage());
        } catch (JMSException e) {
            logger.error(e.getMessage());
        }
    }
}
