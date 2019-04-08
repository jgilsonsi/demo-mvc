package com.jjdev.demomvc.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

/**
 *
 * @author jgilson
 */
@Entity
@Table(name = "funcionarios")
public class JFuncionario extends JAbstractEntity<Long> {

    @NotBlank(message = "Informe um nome.")
    @Size(min = 3, max = 255, message = "O nome do funcionario deve ter entre {min} e {max} caracteres.")
    @Column(nullable = false, unique = true)
    private String nome;

    @NotNull(message = "Salário deve ser informado.")
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    @Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
    private BigDecimal salario;

    @NotNull(message = "Data de entrada deve ser informada.")
    @PastOrPresent(message = "Data de entrada inválida.")
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "data_entrada", nullable = false, columnDefinition = "DATE")
    private LocalDate dataEntrada;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "data_saida", columnDefinition = "DATE")
    private LocalDate dataSaida;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id_fk")
    private JEndereco endereco;

    @NotNull(message = "Cargo deve ser informado")
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
