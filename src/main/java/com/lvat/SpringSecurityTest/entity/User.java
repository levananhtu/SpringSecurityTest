package com.lvat.SpringSecurityTest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "User")
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(targetEntity = AuthorityUser.class)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")//, insertable = false, updatable = false)
    private List<AuthorityUser> authorityUserList;

    public User() {
    }

    //    @ManyToMany
//    @JoinTable(name = "authority_user",
//            joinColumns = @JoinColumn(name = "id", referencedColumnName = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "authority_id"))
//    private List<Authority> authorities;
//

    public User(Long id, String username, String password, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(String username, String password, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @JsonIgnore
    public List<AuthorityUser> getAuthorityUserList() {
        return authorityUserList;
    }

    public void setAuthorityUserList(List<AuthorityUser> authorityUserList) {
        this.authorityUserList = authorityUserList;
    }
}
