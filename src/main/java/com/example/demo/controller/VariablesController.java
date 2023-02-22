package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/variables")
public class VariablesController {

    @GetMapping("/{texto}")
    public ModelAndView variables(
            @PathVariable String texto) {

        ModelAndView mav = new ModelAndView("variables/ver");
        mav.addObject("resultado", "El pathname enviado en la ruta es: ".concat(texto));
        return mav;
    }

}
