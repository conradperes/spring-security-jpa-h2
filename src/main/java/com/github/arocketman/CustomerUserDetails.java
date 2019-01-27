package com.github.arocketman;


import com.github.arocketman.entities.Role;
import com.github.arocketman.entities.User;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CustomerUserDetails implements UserDetails {
    private String username;
    private String password;
    Collection<? extends GrantedAuthority>authorities;
//
//    public CustomerUserDetails(User byUsername) {
//        this.username=byUsername.getUsername();
//        this.password=byUsername.getPassword();
//        List<GrantedAuthority>auths = new ArrayList<>();
//        for(Role role: byUsername.getRoles()){
//            auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
//        }
//        this.authorities=auths;
//
//    }
    public CustomerUserDetails(Optional<User> byUsername) {
        this.username=byUsername.get().getUsername();
        this.password=byUsername.get().getPassword();
        List<GrantedAuthority>auths = new ArrayList<>();
        for(Role role: byUsername.get().getRoles()){
            auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
        }
        this.authorities=auths;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
