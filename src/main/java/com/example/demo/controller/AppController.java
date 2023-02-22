package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.models.Usuario;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/app")
public class AppController {

    @GetMapping(value = { "/", "/index", "/home" })
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("/index");
        mav.addObject("titulo", "Principal Page with Spring Boot");
        return mav;

    }

    @GetMapping(value = { "/perfil" })
    public ModelAndView perfil() {
        ModelAndView mav = new ModelAndView("perfil");
        Usuario usuario = new Usuario(
                "Mario",
                "Montero",
                "mariomontero@email.com");
        mav.addObject("usuario", usuario);
        mav.addObject("titulo",
                "Perfil de usuario ".concat(" ").concat(null != usuario.getNombre() ? usuario.getNombre() : ""));
        return mav;
    }


    @ModelAttribute("usuarios")
    public List<Usuario> seedUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Mario", "Montero", "mario@mail.com"));
        usuarios.add(new Usuario("Juan", "Perez", "jhon@mail.com"));
        usuarios.add(new Usuario("Pedro", "Gomez", "pedro@mail.com"));
        return usuarios;
    }


    @GetMapping(value = { "/listar" })
    public ModelAndView listar() {
        ModelAndView mav = new ModelAndView("listar");
        mav.addObject("titulo", "Listado de usuarios");
        return mav;
    }

}
