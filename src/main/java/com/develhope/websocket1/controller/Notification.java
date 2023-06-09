package com.develhope.websocket1.controller;

import com.develhope.websocket1.entity.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class Notification {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/notification")
    public ResponseEntity sendNotificationToClient(@RequestBody MessageDTO message){
        simpMessagingTemplate.convertAndSend("/topic/broadcast-message",message);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
