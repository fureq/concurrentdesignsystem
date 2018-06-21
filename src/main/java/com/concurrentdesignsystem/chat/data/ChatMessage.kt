package com.concurrentdesignsystem.chat.data

data class ChatMessage(
    val author: String,
    val text: String,
    val created: Long)