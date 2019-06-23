package com.gmail.dissa.vadim.superkid.config;

import com.gmail.dissa.vadim.superkid.properties.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
    private final Properties properties;

    @Autowired
    public MailConfig(Properties properties) {
        this.properties = properties;
    }

    @Bean
    public MailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(properties.getMail().getUsername());
        mailSender.setPassword(properties.getMail().getPassword());
        mailSender.setDefaultEncoding("UTF-8");

        java.util.Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        return mailSender;
    }
}
