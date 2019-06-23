package com.gmail.dissa.vadim.superkid.task;

import com.gmail.dissa.vadim.superkid.service.SendMailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ScheduledTasks {
    private final SendMailService sendMailService;

    @Autowired
    public ScheduledTasks(SendMailService sendMailService){
        this.sendMailService = sendMailService;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void reportAlive(){
        log.info("Superkid service is alive.");
        sendMailService.sendMail("Superkid service is alive.", "Ok");
    }
}
