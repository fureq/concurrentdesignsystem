package com.concurrentdesignsystem.authentication.repository;

import com.concurrentdesignsystem.authentication.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByName(String name);
}
