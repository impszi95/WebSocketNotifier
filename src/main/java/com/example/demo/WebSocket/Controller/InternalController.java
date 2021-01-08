package com.example.demo.WebSocket.Controller;

import com.example.demo.WebSocket.Model.SentNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternalController {

    @Autowired
    WebSocketController webSocketController;

    @RequestMapping("/notify/{userX}-{nameX}/{userY}-{nameY}")
    public void n(@PathVariable String userX,@PathVariable String userY,@PathVariable String nameX,@PathVariable String nameY) throws Exception {

        String message = nameY;
        webSocketController.Notify(userX, message);

        String message2 = nameX;
        webSocketController.Notify(userY, message2);
    }
}
