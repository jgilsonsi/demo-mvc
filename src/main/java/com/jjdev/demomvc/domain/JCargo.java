package com.jjdev.demomvc.domain;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author jgilson
 */
@Entity
@Table(name = "cargos")
public class JCargo extends JAbstractEntity<Long> {

    @Column(name = "nome", nullable = false, unique = true, length = 60)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_departamento_fk")
    private JDepartamento departamento;

    @OneToMany(mappedBy = "cargo")
    private List<JFuncionario> funcionarios;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public JDepartamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(JDepartamento departamento) {
        this.departamento = departamento;
    }

    public List<JFuncionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<JFuncionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
