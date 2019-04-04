package com.jjdev.demomvc.web.controller;

import com.jjdev.demomvc.domain.JCargo;
import com.jjdev.demomvc.domain.JDepartamento;
import com.jjdev.demomvc.service.ICargoService;
import com.jjdev.demomvc.service.IDepartamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
@RequestMapping("/cargos")
public class JCargoController {

    @Autowired
    private ICargoService cargoService;

    @Autowired
    private IDepartamentoService departamentoService;

    @GetMapping("/cadastrar")
    public String cadastrar(@ModelAttribute("cargo") JCargo cargo) {
        return "/cargo/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("cargos", cargoService.buscarTodos());
        return "/cargo/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("cargo") JCargo cargo, RedirectAttributes attr) {
        cargoService.salvar(cargo);
        attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cargo", cargoService.buscarPorId(id));
        return "/cargo/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("cargo") JCargo cargo, RedirectAttributes attr) {
        cargoService.editar(cargo);
        attr.addFlashAttribute("success", "Cargo editado com sucesso.");
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        if (cargoService.cargoTemFuncionarios(id)) {
            attr.addAttribute("fail", "Cargo não removido. Possui funcionário(s) vinculado(s).");
        } else {
            cargoService.excluir(id);
            attr.addAttribute("success", "Cargo excluído com sucesso.");
        }

        return "redirect:/cargos/listar";
    }

    @ModelAttribute("departamentos")
    public List<JDepartamento> listaDeDepartamentos() {
        return departamentoService.buscarTodos();
    }

}
