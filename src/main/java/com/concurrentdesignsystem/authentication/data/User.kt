package com.concurrentdesignsystem.authentication.data

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "UserCollection")
data class User(
        @Id val id: String,
        @Indexed val name: String,
        val password: String?
)