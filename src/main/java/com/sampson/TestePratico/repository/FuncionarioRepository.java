package com.sampson.TestePratico.repository;

import com.sampson.TestePratico.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Funcionario findByNome(String nome);
}
