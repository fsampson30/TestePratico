package com.sampson.TestePratico.repository;

import com.sampson.TestePratico.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByNome(String nome);
}
