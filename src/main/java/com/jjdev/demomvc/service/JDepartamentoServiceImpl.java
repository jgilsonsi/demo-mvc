package com.jjdev.demomvc.service;

import com.jjdev.demomvc.dao.IDepartamentoDao;
import com.jjdev.demomvc.domain.JDepartamento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jgilson
 */
@Service
public class JDepartamentoServiceImpl implements IDepartamentoService {

    @Autowired
    private IDepartamentoDao dao;

    @Override
    @Transactional(readOnly = false)
    public void salvar(JDepartamento departamento) {
        dao.save(departamento);
    }

    @Override
    @Transactional(readOnly = false)
    public void editar(JDepartamento departamento) {
        dao.update(departamento);
    }

    @Override
    @Transactional(readOnly = false)
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public JDepartamento buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JDepartamento> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean departamentoTemCargos(Long id) {
        return !buscarPorId(id).getCargos().isEmpty();
    }

}
