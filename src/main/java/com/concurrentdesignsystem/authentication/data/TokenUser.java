package com.concurrentdesignsystem.authentication.data;

import org.springframework.security.core.authority.AuthorityUtils;

public class TokenUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public TokenUser (User user) {
        super(user.getName(), user.getPassword(), AuthorityUtils.NO_AUTHORITIES);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return user.getId();
    }
}
