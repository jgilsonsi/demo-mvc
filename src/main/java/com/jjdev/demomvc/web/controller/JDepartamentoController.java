package com.jjdev.demomvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jgilson
 */
@Controller
@RequestMapping("departamentos")
public class JDepartamentoController {

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "/departamento/cadastro";
    }

    @GetMapping("/listar")
    public String listar() {
        return "/departamento/lista";
    }

}
