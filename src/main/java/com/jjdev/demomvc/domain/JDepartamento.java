package com.jjdev.demomvc.domain;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author jgilson
 */
@Entity
@Table(name = "departamentos")
public class JDepartamento extends JAbstractEntity<Long> {

    @NotBlank(message = "Informe um nome.")
    @Size(min = 3, max = 60, message = "O nome do departamento deve ter entre {min} e {max} caracteres.")
    @Column(name = "nome", nullable = false, unique = true, length = 60)
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
