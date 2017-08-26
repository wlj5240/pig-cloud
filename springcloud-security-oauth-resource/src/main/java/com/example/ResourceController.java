package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * @email wangiegie@gmail.com
 * @data 2017-08
 */
public class ResourceController {
    @GetMapping("/users")
    ResponseEntity getUsers(Principal principal){

        return ResponseEntity.ok(principal);
    }
}