package com.jjdev.demomvc.domain;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author jgilson
 */
@Entity
@Table(name = "departamentos")
public class JDepartamento extends JAbstractEntity<Long> {

    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @OneToMany(mappedBy = "departamento")
    private List<JCargo> cargos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<JCargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<JCargo> cargos) {
        this.cargos = cargos;
    }

}
