package com.example.demo.WebSocket.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.Binary;

@Data
@AllArgsConstructor
public class Photo {
    @JsonProperty("id")
    private String id;
    @JsonProperty("image")
    private Binary image;

}