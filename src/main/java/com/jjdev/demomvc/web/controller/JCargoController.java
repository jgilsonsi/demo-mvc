package com.jjdev.demomvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jgilson
 */
@Controller
@RequestMapping("/cargos")
public class JCargoController {

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "/cargo/cadastro";
    }

    @GetMapping("/listar")
    public String listar() {
        return "/cargo/lista";
    }

}
