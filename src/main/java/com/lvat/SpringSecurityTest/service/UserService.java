package com.lvat.SpringSecurityTest.service;

import com.lvat.SpringSecurityTest.entity.Authority;
import com.lvat.SpringSecurityTest.entity.AuthorityUser;
import com.lvat.SpringSecurityTest.entity.User;
import com.lvat.SpringSecurityTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Authority> getAuthorityByUsername(String s) {
        List<AuthorityUser> authorityUserList = userRepository.findByUsername(s, User.class).getAuthorityUserList();
        List<Authority> authorityList = new LinkedList<>();
        for (AuthorityUser authorityUser : authorityUserList) {
            authorityList.add(authorityUser.getAuthority());
        }
        return authorityList;

    }

}
