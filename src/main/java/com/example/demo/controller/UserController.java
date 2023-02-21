package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController()
@RequestMapping("/user")
public class UserController {

    @GetMapping(value = { "/index", "/", "", "/home" })
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("user");
        mav.setViewName("user");
        mav.addObject("titulo", "Principal Page with Spring Boot");
        return mav;

    }

}
