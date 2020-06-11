package br.com.itau.techinsiders.holmes.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.techinsiders.holmes.models.Colaborador;
import br.com.itau.techinsiders.holmes.models.Solicitacao;

public interface SolicitacaoRepository extends CrudRepository<Solicitacao, Long> {

    public Optional<Solicitacao> findAllByColaborador(Colaborador colaborador);
    
}