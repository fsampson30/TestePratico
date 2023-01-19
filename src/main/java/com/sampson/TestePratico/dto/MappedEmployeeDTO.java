package com.sampson.TestePratico.dto;

import com.sampson.TestePratico.model.Funcionario;

import java.util.List;

public class MappedEmployeeDTO {
    private String funcao;
    private List<Funcionario> agrupados;

    public MappedEmployeeDTO() {
    }

    public MappedEmployeeDTO(String funcao, List<Funcionario> agrupados) {
        this.funcao = funcao;
        this.agrupados = agrupados;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public List<Funcionario> getAgrupados() {
        return agrupados;
    }

    public void setAgrupados(List<Funcionario> agrupados) {
        this.agrupados = agrupados;
    }
}
