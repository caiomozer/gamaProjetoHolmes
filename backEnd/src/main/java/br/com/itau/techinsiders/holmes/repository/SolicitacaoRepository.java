package br.com.itau.techinsiders.holmes.repository;


import org.springframework.data.repository.CrudRepository;

import br.com.itau.techinsiders.holmes.models.Colaborador;
import br.com.itau.techinsiders.holmes.models.Solicitacao;

public interface SolicitacaoRepository extends CrudRepository<Solicitacao, Long> {

    //public Optional<Solicitacao> findAllByColaborador(Colaborador colaborador);

    public Iterable<Solicitacao> findSolicitacaoByColaborador(Colaborador colaborador);
    
}