package com.jjdev.demomvc.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;

/**
 *
 * @author jgilson
 */
@Entity
@Table(name = "funcionarios")
public class JFuncionario extends JAbstractEntity<Long> {

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
    private BigDecimal salario;

    @Column(name = "data_entrada", nullable = false, columnDefinition = "DATE")
    private LocalDate dataEntrada;

    @Column(name = "data_saida", columnDefinition = "DATE")
    private LocalDate dataSaida;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id_fk")
    private JEndereco endereco;

    @ManyToOne
    @JoinColumn(name = "cargo_id_fk")
    private JCargo cargo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public JEndereco getEndereco() {
        return endereco;
    }

    public void setEndereco(JEndereco endereco) {
        this.endereco = endereco;
    }

    public JCargo getCargo() {
        return cargo;
    }

    public void setCargo(JCargo cargo) {
        this.cargo = cargo;
    }

}
