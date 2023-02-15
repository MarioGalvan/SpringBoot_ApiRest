package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

    @GetMapping("/")
    public String index() {
        return "El reguero con spring boot!";
    }

    @GetMapping("/hello")
    public Object hello() {
        Map<String, Object> object = new HashMap<>();
        object.put("name", "El regue!");
        return object;
    }
}
