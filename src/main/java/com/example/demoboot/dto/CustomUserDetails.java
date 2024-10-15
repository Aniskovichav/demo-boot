package com.example.demoboot.dto;

import java.util.Collection;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String fullname;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
                             String fullname) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.fullname = fullname;
    }
}
