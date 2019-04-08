package com.jjdev.demomvc.web.controller;

import com.jjdev.demomvc.domain.EUF;
import com.jjdev.demomvc.domain.JCargo;
import com.jjdev.demomvc.domain.JFuncionario;
import com.jjdev.demomvc.service.ICargoService;
import com.jjdev.demomvc.service.IFuncionarioService;
import com.jjdev.demomvc.web.validator.JFuncionarioValidator;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author jgilson
 */
@Controller
@RequestMapping("/funcionarios")
public class JFuncionarioController {
    
    @Autowired
    private IFuncionarioService funcionarioService;
    
    @Autowired
    private ICargoService cargoService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new JFuncionarioValidator());
    }
    
    @GetMapping("/cadastrar")
    public String cadastrar(@ModelAttribute("funcionario") JFuncionario funcionario) {
        return "/funcionario/cadastro";
    }
    
    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.buscarTodos());
        return "/funcionario/lista";
    }
    
    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("funcionario") JFuncionario funcionario, BindingResult result, RedirectAttributes attr) {
        
        if (result.hasErrors()) {
            return "/funcionario/cadastro";
        }
        
        funcionarioService.salvar(funcionario);
        attr.addFlashAttribute("success", "Funcionario inserido com sucesso.");
        return "redirect:/funcionarios/cadastrar";
    }
    
    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        return "/funcionario/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(@Valid @ModelAttribute("funcionario") JFuncionario funcionario, BindingResult result, RedirectAttributes attr) {
        
        if (result.hasErrors()) {
            return "/funcionario/cadastro";
        }
        
        funcionarioService.editar(funcionario);
        attr.addFlashAttribute("success", "Funcionario editado com sucesso.");
        return "redirect:/funcionarios/cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        funcionarioService.excluir(id);
        attr.addFlashAttribute("success", "Funcionário excluído com sucesso.");
        return "redirect:/funcionarios/listar";
    }
    
    @GetMapping("/buscar/nome")
    public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.buscarPorNome(nome));
        return "/funcionario/lista";
    }
    
    @GetMapping("/buscar/cargo")
    public String getPorCargo(@RequestParam("id") Long id, ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.buscarPorCargo(id));
        return "/funcionario/lista";
    }
    
    @GetMapping("/buscar/data")
    public String getPorDatas(
            @RequestParam("entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
            @RequestParam("saida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
            ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.buscarPorDatas(entrada, saida));
        return "/funcionario/lista";
    }
    
    @ModelAttribute("cargos")
    public List<JCargo> getCargos() {
        return cargoService.buscarTodos();
    }
    
    @ModelAttribute("ufs")
    public EUF[] getUFs() {
        return EUF.values();
    }
    
}
