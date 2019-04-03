package com.jjdev.demomvc.service;

import com.jjdev.demomvc.domain.JFuncionario;
import java.util.List;

/**
 *
 * @author jgilson
 */
public interface IFuncionarioService {

    void salvar(JFuncionario funcionario);

    void editar(JFuncionario funcionario);

    void excluir(Long id);

    JFuncionario buscarPorId(Long id);

    List<JFuncionario> buscarTodos();

}
