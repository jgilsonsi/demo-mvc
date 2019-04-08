package com.jjdev.demomvc.domain;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jgilson
 */
@Entity
@Table(name = "cargos")
public class JCargo extends JAbstractEntity<Long> {

    @NotBlank(message = "O nome do cargo é obrigatório.")
    @Size(max = 60, message = "O nome do cargo deve ter no máximo {max} caracteres.")
    @Column(name = "nome", nullable = false, unique = true, length = 60)
    private String nome;

    @NotNull(message = "Selecione o departamento relativo ao cargo.")
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
