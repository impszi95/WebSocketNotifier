package com.example.demo.WebSocket.Model;

import lombok.Data;

@Data
public class Notification {
    String userIdX;
    String usernameX;
    byte[] thumbnailX;

    String userIdY;
    String usernameY;
    byte[] thumbnailY;
}
