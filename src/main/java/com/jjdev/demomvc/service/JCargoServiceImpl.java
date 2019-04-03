package com.jjdev.demomvc.service;

import com.jjdev.demomvc.dao.ICargoDao;
import com.jjdev.demomvc.domain.JCargo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jgilson
 */
@Service
@Transactional(readOnly = false)
public class JCargoServiceImpl implements ICargoService {

    @Autowired
    private ICargoDao dao;

    @Override
    public void salvar(JCargo cargo) {
        dao.save(cargo);
    }

    @Override
    public void editar(JCargo cargo) {
        dao.update(cargo);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public JCargo buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JCargo> buscarTodos() {
        return dao.findAll();
    }

}
