package com.concurrentdesignsystem.authentication.data;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

public class UserAuthentication implements Authentication {

    private final TokenUser tokenUser;

    private boolean authenticated = true;

    public UserAuthentication(TokenUser tokenUser) {
        this.tokenUser = tokenUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.NO_AUTHORITIES;
    }

    @Override
    public Object getCredentials() {
        return tokenUser.getPassword();
    }

    @Override
    public Object getDetails() {
        return tokenUser;
    }

    @Override
    public Object getPrincipal() {
        return tokenUser.getUsername();
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) {
        authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return tokenUser.getUsername();
    }
}
