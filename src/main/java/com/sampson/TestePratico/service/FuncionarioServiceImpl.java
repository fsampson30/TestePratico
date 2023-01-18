package com.sampson.TestePratico.service;

import com.sampson.TestePratico.model.Funcionario;
import com.sampson.TestePratico.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> listAll() {
        return funcionarioRepository.findAll();

    }

    @Override
    public void removePersonByNome(String nome) {
        Funcionario byNome = funcionarioRepository.findByNome(nome);
        funcionarioRepository.delete(byNome);
    }

    @Override
    public void setRaise() {

    }

    @Override
    public void mapEmployees() {

    }

    @Override
    public void showBirthdayList() {

    }

    @Override
    public void showOldestEmployee() {

    }

    @Override
    public void listAllAlphabetically() {

    }

    @Override
    public void showSummedSalaries() {

    }

    @Override
    public void listAmountOfSalariesPerPerson() {

    }
}
