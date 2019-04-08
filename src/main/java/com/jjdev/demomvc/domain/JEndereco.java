package com.jjdev.demomvc.domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jgilson
 */
@Entity
@Table(name = "enderecos")
public class JEndereco extends JAbstractEntity<Long> {

    @NotBlank(message = "Informe um logradouro.")
    @Size(min = 3, max = 255, message = "O logradouro deve ter entre {min} e {max} caracteres.")
    @Column(nullable = false)
    private String logradouro;

    @NotBlank(message = "Informe o bairro.")
    @Size(min = 3, max = 255, message = "O bairro deve ter entre {min} e {max} caracteres.")
    @Column(nullable = false)
    private String bairro;

    @NotBlank(message = "Informe a cidade.")
    @Size(min = 3, max = 255, message = "A cidade deve ter entre {min} e {max} caracteres.")
    @Column(nullable = false)
    private String cidade;

    @NotNull(message = "UF deve ser selecionada.")
    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private EUF uf;

    @NotBlank(message = "Informe o cep.")
    @Size(min = 9, max = 9, message = "O CEP deve ter {min} caracteres.")
    @Column(nullable = false, length = 9)
    private String cep;

    @NotNull(message = "Número deve ser informado.")
    @Digits(integer = 5, fraction = 0, message = "Limite de caracteres atingido.")
    @Column(nullable = false, length = 5)
    private Integer numero;

    @Size(max = 255, message = "Complemento deve ter no máximo {max} caracteres.")
    private String complemento;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public EUF getUf() {
        return uf;
    }

    public void setUf(EUF uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

}
