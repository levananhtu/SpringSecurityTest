package com.lvat.SpringSecurityTest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
    @RequestMapping(path = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/menu", method = RequestMethod.GET)
    public String menu() {
        return "menu";
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public String user() {
        return "user";
    }

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin";
    }

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String error() {
        return "error";
    }
}
