package com.sampson.TestePratico.controller;

import com.sampson.TestePratico.dto.NameAmountSalariesDTO;
import com.sampson.TestePratico.model.Funcionario;
import com.sampson.TestePratico.service.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioServiceImpl funcionarioService;

    @GetMapping
    public List<Funcionario> listAll() {
        return funcionarioService.listAll();
    }

    @GetMapping("/niver")
    public List<Funcionario> getBirthdayList() {
        return funcionarioService.showBirthdayList();
    }

    @GetMapping("/older")
    public Funcionario getOldestEmployee() {
        return funcionarioService.showOldestEmployee();
    }

    @GetMapping("/alphabetic")
    public List<Funcionario> listAllAlphabetically() {
        return funcionarioService.listAllAlphabetically();
    }

    @GetMapping("/sum")
    public String getSalariesSummed() {
        return funcionarioService.showSummedSalaries();
    }

    @GetMapping("/salaries")
    public List<NameAmountSalariesDTO> getAmountOfSalaries() {
        return funcionarioService.listAmountOfSalariesPerPerson();
    }

    @PostMapping("/raise")
    public ResponseEntity<Void> setRaise(){
        funcionarioService.setRaise();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/grouped")
    public Map<String, List<Funcionario>> getMappedEmployees(){
        return funcionarioService.mapEmployees();
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<Void> deleteByName(@PathVariable String nome) {
        funcionarioService.removePersonByNome(nome);
        return ResponseEntity.noContent().build();
    }
}
