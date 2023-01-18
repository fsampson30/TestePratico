package com.sampson.TestePratico.service;

import com.sampson.TestePratico.exception.BadRequestException;
import com.sampson.TestePratico.model.Funcionario;
import com.sampson.TestePratico.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
        funcionarioRepository.delete(funcionarioRepository.findByNome(nome)
                .orElseThrow(() -> new BadRequestException("Funcionário não encontrado")));
    }

    @Override
    public void setRaise() {

    }

    @Override
    public void mapEmployees() {

    }

    @Override
    public List<Funcionario> showBirthdayList() {
        ArrayList<Funcionario> birthdayList = new ArrayList<>();
        for (Funcionario funcionario : funcionarioRepository.findAll()) {
            if (funcionario.getDataNascimento().getMonthValue() == 10 ||
                    funcionario.getDataNascimento().getMonthValue() == 12) {
                birthdayList.add(funcionario);
            }
        }
        return birthdayList;
    }

    @Override
    public Funcionario showOldestEmployee() {
        Funcionario oldest = new Funcionario();
        int greaterAge = 0;
        for (Funcionario funcionario : funcionarioRepository.findAll()) {
            int currentAge = Math.abs(funcionario.getDataNascimento().compareTo(LocalDate.now()));
            if (currentAge > greaterAge) {
                greaterAge = currentAge;
                oldest = funcionario;
            }
        }
        return oldest;
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
