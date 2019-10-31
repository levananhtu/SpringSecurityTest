package com.lvat.SpringSecurityTest.configs;

import com.lvat.SpringSecurityTest.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private String[] resources = {"/include/**", "/css/**", "/icon/**", "/img/**", "/js/**", "/layer/**"};
    private GrantedAuthority userAuthority = new SimpleGrantedAuthority("ROLE_USER");
    private GrantedAuthority adminAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsServiceImp userDetailsServiceImp;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(resources).permitAll();
        http.authorizeRequests().antMatchers("/admin/**").hasAuthority(adminAuthority.getAuthority());
        http.authorizeRequests().antMatchers("/user/**").hasAnyAuthority(userAuthority.getAuthority(), adminAuthority.getAuthority());
//        http.authorizeRequests().antMatchers("/login").not().hasAnyAuthority(userAuthority.getAuthority(), adminAuthority.getAuthority());
//        http.authorizeRequests().antMatchers("/logout").hasAnyAuthority(userAuthority.getAuthority(), adminAuthority.getAuthority());
        http.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureUrl("/error")
                .loginProcessingUrl("/j_spring_security_login")
                .defaultSuccessUrl("/menu").permitAll();

        http.logout()
                .logoutSuccessUrl("/login?logout")
                .logoutUrl("/j_spring_security_logout");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsServiceImp).passwordEncoder(passwordEncoder());
        System.out.println("hello sucker");
//        System.out.println(userDetailsServiceImp.getAuthorityByUsername("admin"));
    }
}
