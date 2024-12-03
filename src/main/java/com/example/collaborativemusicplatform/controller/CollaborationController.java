package com.example.collaborativemusicplatform.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CollaborationController {
    @MessageMapping("/activity")
    @SendTo("/topic/activity")
    public String broadcastActivity(String activity) {
        return activity;
    }
}
