package com.example.demo.WebSocket.Controller;

import com.example.demo.WebSocket.Model.UserNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/notification")
    public void Notify(String userId, UserNotification userNotification) throws Exception {
        simpMessagingTemplate.convertAndSend("/queue/newMatch/" + userId, userNotification);
    }
}