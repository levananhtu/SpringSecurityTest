package com.lvat.SpringSecurityTest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "authority_user", indexes = {@Index(unique = true, columnList = "user_id, authority_id", name = "uq_user_id_authority_id")})
@Entity(name = "AuthorityUser")
public class AuthorityUser implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "authority_id")
    private Long authorityId;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "authority_id", referencedColumnName = "authority_id", insertable = false, updatable = false)
    private Authority authority;

    public AuthorityUser() {
    }

    public AuthorityUser(Long id, Long authorityId, Long userId, User user) {
        this.id = id;
        this.authorityId = authorityId;
        this.userId = userId;
        this.user = user;
    }

    public AuthorityUser(Long authorityId, Long userId, User user) {
        this.authorityId = authorityId;
        this.userId = userId;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonIgnore
    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
