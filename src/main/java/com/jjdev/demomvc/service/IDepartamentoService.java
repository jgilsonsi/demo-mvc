package com.jjdev.demomvc.service;

import com.jjdev.demomvc.domain.JDepartamento;
import java.util.List;

/**
 *
 * @author jgilson
 */
public interface IDepartamentoService {

    void salvar(JDepartamento departamento);

    void editar(JDepartamento departamento);

    void excluir(Long id);

    JDepartamento buscarPorId(Long id);

    List<JDepartamento> buscarTodos();

    boolean departamentoTemCargos(Long id);

}
