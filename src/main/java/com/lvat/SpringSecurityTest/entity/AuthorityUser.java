package com.lvat.SpringSecurityTest.entity;

import javax.persistence.*;

@Table(name = "authority_user", indexes = {@Index(unique = true, columnList = "user_id, authority_id")})
@Entity(name = "AuthorityUser")
public class AuthorityUser {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "authority_id")
    private Long authorityId;

    @Column(name = "user_id")
    private Long userId;

}
