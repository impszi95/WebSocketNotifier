package com.example.demo.WebSocket.Controller;

import com.example.demo.WebSocket.Model.NewMatchNotification;
import com.example.demo.WebSocket.Model.SentNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/notification")
    public void Notify(String userId, String message) throws Exception {
        simpMessagingTemplate.convertAndSend("/queue/newMatch/" + userId, message);
    }
}