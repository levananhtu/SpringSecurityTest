package com.lvat.SpringSecurityTest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Authority")
@Table(name = "authority")
public class Authority implements Serializable {
    @Id
    @Column(name = "authority_id")
    @GeneratedValue
    private Long id;

    @Column(unique = true, name = "authority_name")
    private String authorityName;

//    @ManyToMany
//    @JoinTable(name = "authority_user",
//            inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "user_id"),
//            joinColumns = @JoinColumn(name = "id", referencedColumnName = "authority_id"))
//    private List<User> users;

    @OneToMany
    @JoinColumn(referencedColumnName = "authority_id", name = "authority_id")//, insertable = false, updatable = false)
    private List<AuthorityUser> authorityUserList;

    public Authority() {
    }

    public Authority(Long id, String authorityName) {
        this.id = id;
        this.authorityName = authorityName;
    }

    public Authority(String authorityName) {
        this.authorityName = authorityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    @JsonIgnore
    public List<AuthorityUser> getAuthorityUserList() {
        return authorityUserList;
    }

    public void setAuthorityUserList(List<AuthorityUser> authorityUserList) {
        this.authorityUserList = authorityUserList;
    }
}
