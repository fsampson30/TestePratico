package com.sampson.TestePratico.service;

import com.sampson.TestePratico.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    public List<Funcionario> listAll();

    public void removePersonByName(String name);

    public void setRaise();

    public void mapEmployees();

    public void showBirthdayList();

    public void showOldestEmployee();

    public void listAllAlphabetically();

    public void showSummedSalaries();

    public void listAmountOfSalariesPerPerson();


}
