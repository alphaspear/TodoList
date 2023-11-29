package com.alphaspear.ToDoList.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class health {
    @GetMapping()
    public ResponseEntity<Map<String, String>> healthCheck() throws UnknownHostException {
        Map<String,String> data = new HashMap<>();
        data.put("hostname", InetAddress.getLocalHost().getHostName() );
        data.put("IPaddress", InetAddress.getLocalHost().getHostAddress());
        data.put("message","server running fine");
        ResponseEntity<Map<String, String>> resp;
        resp = new ResponseEntity<>(data, HttpStatus.I_AM_A_TEAPOT);
        return resp;
    }
}
