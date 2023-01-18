package com.sampson.TestePratico.dto;

import java.math.BigDecimal;

public class NameAmountSalariesDTO {

    private String nome;
    private BigDecimal amount;

    public NameAmountSalariesDTO() {
    }

    public NameAmountSalariesDTO(String nome, BigDecimal amount) {
        this.nome = nome;
        this.amount = amount;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
