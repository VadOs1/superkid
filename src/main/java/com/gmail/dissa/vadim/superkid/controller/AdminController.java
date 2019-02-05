package com.gmail.dissa.vadim.superkid.controller;

import com.gmail.dissa.vadim.superkid.service.CRMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
public class AdminController {
    private final CRMService crmService;

    @Autowired
    public AdminController(CRMService crmService) {
        this.crmService = crmService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView admin(ModelAndView modelAndView) {
        modelAndView.addObject("userName", crmService.getAuthenticatedUserName());
        modelAndView.setViewName("admin_index");
        return modelAndView;
    }
}