package com.jjdev.demomvc.dao;

import com.jjdev.demomvc.domain.JFuncionario;
import java.util.List;

/**
 *
 * @author jgilson
 */
public interface IFuncionarioDao {

    void save(JFuncionario funcionario);

    void update(JFuncionario funcionario);

    void delete(Long id);

    JFuncionario findById(Long id);

    List<JFuncionario> findAll();

}
