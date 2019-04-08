package com.jjdev.demomvc.dao;

import com.jjdev.demomvc.domain.JFuncionario;
import java.time.LocalDate;
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

    List<JFuncionario> findByNome(String nome);

    List<JFuncionario> findByCargo(Long id);

    List<JFuncionario> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);

    List<JFuncionario> findByDataEntrada(LocalDate entrada);

    List<JFuncionario> findByDataSaida(LocalDate saida);

}
