package com.sampson.TestePratico.service;

import com.sampson.TestePratico.dto.NameAmountSalariesDTO;
import com.sampson.TestePratico.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    public List<Funcionario> listAll();

    public void removePersonByNome(String nome);

    public void setRaise();

    public void mapEmployees();

    public List<Funcionario> showBirthdayList();

    public Funcionario showOldestEmployee();

    public List<Funcionario> listAllAlphabetically();

    public String showSummedSalaries();

    public List<NameAmountSalariesDTO> listAmountOfSalariesPerPerson();


}
