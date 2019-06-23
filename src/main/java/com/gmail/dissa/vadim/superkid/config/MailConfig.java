package com.gmail.dissa.vadim.superkid.config;

import com.gmail.dissa.vadim.superkid.property.Properties;
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
        mailSender.setHost(properties.getMail().getHost());
        mailSender.setPort(properties.getMail().getPort());
        mailSender.setUsername(properties.getMail().getUsername());
        mailSender.setPassword(properties.getMail().getPassword());
        mailSender.setDefaultEncoding(properties.getMail().getEncoding());

        java.util.Properties props = mailSender.getJavaMailProperties();
        props.put(properties.getMail().getAuth(), properties.getMail().getAuthStatus());
        props.put(properties.getMail().getStarttls(), properties.getMail().getStarttlsStatus());
        return mailSender;
    }
}
