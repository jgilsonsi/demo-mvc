package com.jjdev.demomvc.dao;

import com.jjdev.demomvc.domain.JDepartamento;
import java.util.List;

/**
 *
 * @author jgilson
 */
public interface IDepartamentoDao {

    void save(JDepartamento departamento);

    void update(JDepartamento departamento);

    void delete(Long id);

    JDepartamento findById(Long id);

    List<JDepartamento> findAll();

}
