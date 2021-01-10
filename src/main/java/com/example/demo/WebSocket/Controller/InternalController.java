package com.example.demo.WebSocket.Controller;

import com.example.demo.WebSocket.Model.UserNotification;
import com.example.demo.WebSocket.Model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class InternalController {

    @Autowired
    WebSocketController webSocketController;

    @RequestMapping("/notify")
    public void n(@RequestBody Notification notification) throws Exception {

        UserNotification userNotificationX = new UserNotification();
        userNotificationX.setMatchName(notification.getUsernameY());
        userNotificationX.setMatchthumbnail(Base64.getEncoder().encodeToString(notification.getThumbnailY()));
        webSocketController.Notify(notification.getUserIdX(), userNotificationX);

        UserNotification userNotificationY = new UserNotification();
        userNotificationY.setMatchName(notification.getUsernameX());
        userNotificationY.setMatchthumbnail(Base64.getEncoder().encodeToString(notification.getThumbnailX()));
        webSocketController.Notify(notification.getUserIdY(), userNotificationY);
    }
}
