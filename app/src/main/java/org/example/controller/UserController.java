package org.example.controller;

import org.example.enities.UserInfo;
import org.example.enities.UserInfoDto;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController{

        @Autowired
        private UserService userService;

        @PostMapping("/user/v1/createUpdate")
        public ResponseEntity<UserInfoDto> createUpdate(@RequestBody UserInfoDto userInfoDto){
            try{
                UserInfoDto user=userService.createOrUpdateUser(userInfoDto);
                 return new ResponseEntity<>(user, HttpStatus.OK);

            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }

    @GetMapping("/user/v1/getUser")
    public ResponseEntity<UserInfoDto> getUser(@RequestBody UserInfoDto userInfoDto){
        try{
            UserInfoDto user = userService.getUser(userInfoDto);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
