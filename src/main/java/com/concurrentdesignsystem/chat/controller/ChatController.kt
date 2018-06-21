package com.concurrentdesignsystem.chat.controller

import com.concurrentdesignsystem.chat.data.ChatMessage
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class ChatController {

    @MessageMapping("/chat.message")
    @SendTo("/messages/")
    fun onNewMessage(msg: ChatMessage): ChatMessage {
        Thread.sleep(1000) // simulated delay
        return msg
    }
}