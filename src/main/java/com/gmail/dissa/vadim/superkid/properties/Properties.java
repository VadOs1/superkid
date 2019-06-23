package com.gmail.dissa.vadim.superkid.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "superkid")
public class Properties {
    private Mail mail;
}
