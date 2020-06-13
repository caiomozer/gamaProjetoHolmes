package br.com.itau.techinsiders.holmes.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    // localhost:8080/
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String status() {
        return "{\"status\": \"running\"}";
    }

}