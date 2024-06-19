package com.Gitto.plantler.domain.common;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetail extends User {

    private String memberName;
    private Long id;

    public CustomUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
        this.memberName = memberName;
    }

    public String getMemberName(){
        return memberName;
    }

    public Long getId() {
        return id;
    }
}
