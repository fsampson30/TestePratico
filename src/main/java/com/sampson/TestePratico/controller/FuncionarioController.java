package com.sampson.TestePratico.controller;

import com.sampson.TestePratico.model.Funcionario;
import com.sampson.TestePratico.service.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{nome}")
    public ResponseEntity<Void> deleteByName(@PathVariable String nome){
        funcionarioService.removePersonByNome(nome);
        return ResponseEntity.noContent().build();
    }
}
