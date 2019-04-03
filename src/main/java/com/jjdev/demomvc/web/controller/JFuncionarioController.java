package com.jjdev.demomvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jgilson
 */
@Controller
@RequestMapping("/funcionarios")
public class JFuncionarioController {

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "/funcionario/cadastro";
    }

    @GetMapping("/listar")
    public String listar() {
        return "/funcionario/lista";
    }

}
