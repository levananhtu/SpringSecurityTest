package com.lvat.SpringSecurityTest.controllers;

import com.lvat.SpringSecurityTest.entity.Authority;
import com.lvat.SpringSecurityTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "username", method = RequestMethod.GET)
    public List<Authority> getAuthorities(@RequestParam(value = "username", defaultValue = "admin") String username) {
        return userService.getAuthorityByUsername(username);
    }
}
