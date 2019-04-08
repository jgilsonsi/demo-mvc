package com.jjdev.demomvc.web.controller;

import com.jjdev.demomvc.domain.JDepartamento;
import com.jjdev.demomvc.service.IDepartamentoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author jgilson
 */
@Controller
@RequestMapping("departamentos")
public class JDepartamentoController {

    @Autowired
    private IDepartamentoService departamentoService;

    @GetMapping("/cadastrar")
    public String cadastrar(@ModelAttribute("departamento") JDepartamento departamento) {
        return "/departamento/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("departamentos", departamentoService.buscarTodos());
        return "/departamento/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("departamento") JDepartamento departamento, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "/departamento/cadastro";
        }

        departamentoService.salvar(departamento);
        attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("departamento", departamentoService.buscarPorId(id));
        return "/departamento/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid @ModelAttribute("departamento") JDepartamento departamento, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "/departamento/cadastro";
        }

        departamentoService.editar(departamento);
        attr.addFlashAttribute("success", "Departamento editado com sucesso.");
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        if (departamentoService.departamentoTemCargos(id)) {
            model.addAttribute("fail", "Departamento não removido. Possui cargos(s) vinculado(s).");
        } else {
            departamentoService.excluir(id);
            model.addAttribute("success", "Departamento excluído com sucesso.");
        }

        return listar(model);
    }

}
