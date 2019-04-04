package com.jjdev.demomvc.service;

import com.jjdev.demomvc.domain.JCargo;
import java.util.List;

/**
 *
 * @author jgilson
 */
public interface ICargoService {

    void salvar(JCargo cargo);

    void editar(JCargo cargo);

    void excluir(Long id);

    JCargo buscarPorId(Long id);

    List<JCargo> buscarTodos();

    boolean cargoTemFuncionarios(Long id);

}
