package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{


    @GetMapping("/api")
    public String name(){
        return "Divyanshu";
    }


}
