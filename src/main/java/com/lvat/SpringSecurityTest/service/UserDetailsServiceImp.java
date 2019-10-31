package com.lvat.SpringSecurityTest.service;

import com.lvat.SpringSecurityTest.entity.Authority;
import com.lvat.SpringSecurityTest.entity.AuthorityUser;
import com.lvat.SpringSecurityTest.entity.User;
import com.lvat.SpringSecurityTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s, User.class);
        List<AuthorityUser> authorityUserList = user.getAuthorityUserList();
        List<GrantedAuthority> grantedAuthorities = new LinkedList<>();
        for (AuthorityUser authorityUser : authorityUserList) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authorityUser.getAuthority().getAuthorityName()));
        }
        for (GrantedAuthority grantedAuthority : grantedAuthorities) {
            System.out.println(grantedAuthority.getAuthority());
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

}
