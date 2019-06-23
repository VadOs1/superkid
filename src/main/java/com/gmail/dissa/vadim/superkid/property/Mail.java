package com.gmail.dissa.vadim.superkid.property;

import lombok.Data;

import java.util.List;

@Data
public class Mail {
    private String username;
    private String password;
    private List<String> receivers;
    private String host;
    private int port;
    private String encoding;
    private String auth;
    private String authStatus;
    private String starttls;
    private String starttlsStatus;
}
