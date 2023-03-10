package com.sampson.TestePratico.service;

import com.sampson.TestePratico.dto.NameAmountSalariesDTO;
import com.sampson.TestePratico.exception.BadRequestException;
import com.sampson.TestePratico.model.Funcionario;
import com.sampson.TestePratico.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

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
        for (Funcionario funcionario : funcionarioRepository.findAll()) {
            funcionario.setSalario(funcionario.getSalario().multiply(BigDecimal.valueOf(1.1)));
            funcionarioRepository.save(funcionario);
        }
    }

    @Override
    public Map<String, List<Funcionario>> mapEmployees() {
        return funcionarioRepository.findAll().stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
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
    public List<Funcionario> listAllAlphabetically() {
        return funcionarioRepository.findAll().stream().sorted(Comparator.comparing(Funcionario::getNome)).collect(Collectors.toList());

    }

    @Override
    public String showSummedSalaries() {
        BigDecimal summedSalaries = BigDecimal.ZERO;
        for (Funcionario funcionario : funcionarioRepository.findAll()) {
            summedSalaries = summedSalaries.add(funcionario.getSalario());
        }
        return "Sum of salaries:" + NumberFormat.getCurrencyInstance().format(summedSalaries);
    }

    @Override
    public List<NameAmountSalariesDTO> listAmountOfSalariesPerPerson() {
        List<NameAmountSalariesDTO> returnList = new ArrayList<>();
        for (Funcionario funcionario : funcionarioRepository.findAll()) {
            BigDecimal amount = funcionario.getSalario().divide(BigDecimal.valueOf(1212.00), 2, RoundingMode.HALF_UP);
            returnList.add(new NameAmountSalariesDTO(funcionario.getNome(), amount));
        }
        return returnList;
    }
}
