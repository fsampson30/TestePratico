package com.sampson.TestePratico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Funcionario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal salario;
    private String funcao;

    public Funcionario() {
    }

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Funcionário { " +
                "Nome: " + super.getNome() + " - " +
                "Data de Nascimento: " + super.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - " +
                "salário: " + NumberFormat.getCurrencyInstance().format(salario) + " - " +
                "função: " + funcao + "}" + '\n';
    }
}
