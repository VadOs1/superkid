package com.gmail.dissa.vadim.superkid.listener;

import com.gmail.dissa.vadim.superkid.service.SendMailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ContextListener {
    private final SendMailService sendMailService;
    private final Environment environment;

    @Autowired
    public ContextListener(SendMailService sendMailService, Environment environment) {
        this.sendMailService = sendMailService;
        this.environment = environment;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEventListener() {
        log.info("Superkid application context refreshed");
        sendMailService.sendMail(String.format("Superkid application started on %s environment",
                String.join(",", environment.getActiveProfiles())), "Ok");
    }

    @EventListener({ContextClosedEvent.class, ContextStoppedEvent.class})
    public void contextClosedEventListener() {
        log.info("Superkid application context closed / stopped");
        sendMailService.sendMail(String.format("Superkid application stopped on %s environment",
                String.join(",", environment.getActiveProfiles())), "Ok");
    }
}
