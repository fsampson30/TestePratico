package com.sampson.TestePratico.controller;

import com.sampson.TestePratico.model.Funcionario;
import com.sampson.TestePratico.service.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioServiceImpl funcionarioService;

    @GetMapping
    public List<Funcionario> listAll(){
        return funcionarioService.listAll();
    }
}
