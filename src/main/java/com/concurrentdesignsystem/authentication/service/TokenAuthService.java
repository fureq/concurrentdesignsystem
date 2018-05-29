package com.concurrentdesignsystem.authentication.service;

import com.concurrentdesignsystem.authentication.data.TokenUser;
import com.concurrentdesignsystem.authentication.data.User;
import com.concurrentdesignsystem.authentication.data.UserAuthentication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Service
public class TokenAuthService {

    //1 day
    private static final long VALIDITY_TIME_MS =  24 * 60 * 60 * 1000;
    private static final String AUTH_HEADER_NAME = "x-auth-token";

    @Value("${token.secret}")
    private String secret;

    public String addAuthentication(HttpServletResponse httpServletResponse, TokenUser tokenUser) {
        String token = createTokenForUser(tokenUser.getUser());
        httpServletResponse.addHeader(AUTH_HEADER_NAME, token);
        return token;
    }

    public Authentication getAuthentication(HttpServletRequest httpServletRequest) {
        final String token = httpServletRequest.getHeader(AUTH_HEADER_NAME);
        if (token == null || token.isEmpty()) {
            return null;
        }
        final TokenUser user = parseUserFromToken(token);
        if (user == null) {
            return null;
        }
        return new UserAuthentication(user);
    }

    public String createTokenForUser(User user) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + VALIDITY_TIME_MS))
                .setSubject(toJSON(user))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public TokenUser parseUserFromToken(final String tokenUser) {
        return new TokenUser(fromJSON(
                Jwts.parser()
                        .setSigningKey(secret)
                        .parseClaimsJws(tokenUser)
                        .getBody()
                        .getSubject()
        ));
    }

    private String toJSON(User user) {
        try {
            return new ObjectMapper().writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }

    private User fromJSON(final String userJSON) {
        try {
            return new ObjectMapper().readValue(userJSON, User.class);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
