package com.lvat.SpringSecurityTest.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Authority")
@Table(name = "authority")
public class Authority {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(unique = true, name = "authority_name")
    private String authorityName;

//    @ManyToMany
//    @JoinTable(name = "authority_user",
//            inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "user_id"),
//            joinColumns = @JoinColumn(name = "id", referencedColumnName = "authority_id"))
//    private List<User> users;

    @OneToMany(targetEntity = AuthorityUser.class)
    @JoinColumn(referencedColumnName = "authority_id", name = "id", insertable = false, updatable = false)
    List<AuthorityUser> authorityUserList;

    public Authority() {
    }

    public Authority(Long id, String authorityName) {
        this.id = id;
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

    public List<AuthorityUser> getAuthorityUserList() {
        return authorityUserList;
    }

    public void setAuthorityUserList(List<AuthorityUser> authorityUserList) {
        this.authorityUserList = authorityUserList;
    }
}
