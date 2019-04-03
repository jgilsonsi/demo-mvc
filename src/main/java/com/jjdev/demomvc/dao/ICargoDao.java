package com.jjdev.demomvc.dao;

import com.jjdev.demomvc.domain.JCargo;
import java.util.List;

/**
 *
 * @author jgilson
 */
public interface ICargoDao {

    void save(JCargo cargo);

    void update(JCargo cargo);

    void delete(Long id);

    JCargo findById(Long id);

    List<JCargo> findAll();

}
