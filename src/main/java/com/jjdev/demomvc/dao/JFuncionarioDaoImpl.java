package com.jjdev.demomvc.dao;

import com.jjdev.demomvc.domain.JFuncionario;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jgilson
 */
@Repository
public class JFuncionarioDaoImpl extends JAbstractDao<JFuncionario, Long> implements IFuncionarioDao {

    @Override
    public List<JFuncionario> findByNome(String nome) {
        return createQuery("select f from JFuncionario f where f.nome like concat('%',?1,'%')", nome);
    }

    @Override
    public List<JFuncionario> findByCargo(Long id) {
        return createQuery("select f from JFuncionario f where f.cargo.id = ?1", id);
    }

    @Override
    public List<JFuncionario> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
        String jpql = new StringBuilder("select f from JFuncionario f ")
                .append("where f.dataEntrada >= ?1 and f.dataSaida <= ?2 ")
                .append("order by f.dataEntrada asc")
                .toString();
        return createQuery(jpql, entrada, saida);
    }

    @Override
    public List<JFuncionario> findByDataEntrada(LocalDate entrada) {
        String jpql = new StringBuilder("select f from JFuncionario f ")
                .append("where f.dataEntrada = ?1 ")
                .append("order by f.dataEntrada asc")
                .toString();
        return createQuery(jpql, entrada);
    }

    @Override
    public List<JFuncionario> findByDataSaida(LocalDate saida) {
        String jpql = new StringBuilder("select f from JFuncionario f ")
                .append("where f.dataSaida = ?1 ")
                .append("order by f.dataEntrada asc")
                .toString();
        return createQuery(jpql, saida);
    }

}
