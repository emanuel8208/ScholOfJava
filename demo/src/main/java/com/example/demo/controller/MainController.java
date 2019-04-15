package com.example.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(path = "/myresource", method = RequestMethod.GET)
    public ResponseEntity<String> firstGet() {
        String value = "Welcome! This is my first web servoce";
        ResponseEntity<String> responseEntity = new ResponseEntity<>(value, HttpStatus.OK);
        return responseEntity;
    }
}
