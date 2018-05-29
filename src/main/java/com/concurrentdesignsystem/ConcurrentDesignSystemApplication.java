package com.concurrentdesignsystem;

import com.concurrentdesignsystem.authentication.data.User;
import com.concurrentdesignsystem.authentication.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.concurrentdesignsystem")
public class ConcurrentDesignSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConcurrentDesignSystemApplication.class, args);
    }

    @Bean
    InitializingBean insertDefaultUsers() {
        return new InitializingBean() {

            @Autowired
            private UserRepository userRepository;

            @Override
            public void afterPropertiesSet() throws Exception {
                addUser("root", "root");
            }

            private void addUser(String username, String password) {
                User user = userRepository.findByName(username).orElseGet(() -> new User(null, username, new BCryptPasswordEncoder().encode(password)));
                userRepository.save(user);
            }
        };
    }
}
