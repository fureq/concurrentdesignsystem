package com.concurrentdesignsystem.authentication.service;

import com.concurrentdesignsystem.authentication.data.TokenUser;
import com.concurrentdesignsystem.authentication.data.User;
import com.concurrentdesignsystem.authentication.repository.UserRepository;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();


    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public TokenUser loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByName(username).orElseThrow(() -> new UsernameNotFoundException("Cannot find username: " + username));

        TokenUser currentUser = new TokenUser(user);
        detailsChecker.check(currentUser);

        return currentUser;
    }
}
