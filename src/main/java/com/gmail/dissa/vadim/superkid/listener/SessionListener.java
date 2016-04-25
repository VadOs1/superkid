package com.gmail.dissa.vadim.superkid.listener;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionListener implements HttpSessionListener {

    // Setting manual session time
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setMaxInactiveInterval(90 * 24 * 60 * 60);

    }
    // Add later if needed
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {}
}
