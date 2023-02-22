package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/params")
public class ParamsController {
    

    @GetMapping("/")
    public ModelAndView param(
        @RequestParam(name = "message", required = true, defaultValue = "algún valor...") String message) {
        ModelAndView mav = new ModelAndView("params/index");
        mav.addObject("resultado", "El texto enviado en el parámetro es: ".concat(message));
        return mav;
    }


    @GetMapping("/sendparams")
    public ModelAndView sendParams() {
        ModelAndView mav = new ModelAndView("params/ver");
        mav.addObject("resultado", "Enviar parametros desde la vista");
        return mav;
    }


}
