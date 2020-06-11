package br.com.itau.techinsiders.holmes.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.techinsiders.holmes.models.Colaborador;

public interface ColaboradorRepository extends CrudRepository<Colaborador, Long> {

    // find = SELECT *
    // PESSOA = FROM PESSOA
    // WHERE telefone = ????
    //public Optional<Colaborador> findPessoaByTelefone(String telefone);
    public Optional<Colaborador> findColaboradorByRacf(String racf);
}