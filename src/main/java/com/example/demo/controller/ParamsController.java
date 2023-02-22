package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;

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

    @GetMapping("/mix")
    public ModelAndView mixParams(
            @RequestParam(name = "message", required = true, defaultValue = "algún valor...") String message,
            @RequestParam(name = "number", required = true, defaultValue = "0") Integer number,
            @RequestParam(name = "decimal", required = true, defaultValue = "0.0") Double decimal) {
        ModelAndView mav = new ModelAndView("params/mix");
        mav.addObject("resultado", "El texto enviado en el parámetro es: ".concat(message));
        mav.addObject("resultado1", "El número enviado en el parámetro es: ".concat(number.toString()));
        mav.addObject("resultado2", "El decimal enviado en el parámetro es: ".concat(decimal.toString()));
        return mav;
    }

    @GetMapping("/mix2")
    public String parammix2(
            HttpServletRequest request) {
        Integer number = 0;
        String message = request.getParameter("message");
        try {
            number = Integer.parseInt(request.getParameter("number"));
        } catch (Exception e) {
            number = 0;

        }
        Double decimal = Double.parseDouble(request.getParameter("decimal"));
        request.setAttribute("resultado", "El texto enviado en el parámetro es: ".concat(message));
        request.setAttribute("resultado1", "El número enviado en el parámetro es: ".concat(number.toString()));
        request.setAttribute("resultado2", "El decimal enviado en el parámetro es: ".concat(decimal.toString()));
        return "params/mix";
    }

}
