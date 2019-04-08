package com.jjdev.demomvc.service;

import com.jjdev.demomvc.dao.IFuncionarioDao;
import com.jjdev.demomvc.domain.JFuncionario;
import java.time.LocalDate;
import java.util.ArrayList;
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
public class JFuncionarioServiceImpl implements IFuncionarioService {

    @Autowired
    private IFuncionarioDao dao;

    @Override
    public void salvar(JFuncionario funcionario) {
        dao.save(funcionario);
    }

    @Override
    public void editar(JFuncionario funcionario) {
        dao.update(funcionario);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public JFuncionario buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JFuncionario> buscarTodos() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<JFuncionario> buscarPorNome(String nome) {
        return dao.findByNome(nome);
    }

    @Override
    public List<JFuncionario> buscarPorCargo(Long id) {
        return dao.findByCargo(id);
    }

    @Override
    public List<JFuncionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
        if (entrada != null && saida != null) {
            return dao.findByDataEntradaDataSaida(entrada, saida);
        } else if (entrada != null) {
            return dao.findByDataEntrada(entrada);
        } else if (saida != null) {
            return dao.findByDataSaida(saida);
        } else {
            return new ArrayList<>();
        }
    }

}
