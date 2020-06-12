package br.com.itau.techinsiders.holmes.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.techinsiders.holmes.models.Solicitacao;
import br.com.itau.techinsiders.holmes.models.Colaborador;
import br.com.itau.techinsiders.holmes.repository.ColaboradorRepository;
import br.com.itau.techinsiders.holmes.repository.SolicitacaoRepository;

@RestController
public class SolicitacaoController {

    
    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    
    // tem que validar...
    @GetMapping(path = "/inicio/solicitacao{racf}")
    public Iterable<Solicitacao> listarSolicitacao(@PathVariable("racf") String racf) {
        Optional<Colaborador> optionalColaborador = colaboradorRepository.findColaboradorByRacf(racf);
        if (optionalColaborador.isPresent()) {
            Iterable<Solicitacao> solicitacao = solicitacaoRepository.findSolicitacaoByColaborador(optionalColaborador.get());
            return solicitacao;
        }
        return null;
    }

    // tem que validar...
    @PostMapping(path = "/novasolicitacao",  consumes = "application/json", produces = "application/json")
    public Solicitacao addSolicitacao(@RequestBody Solicitacao novaSolicitacao) {
        
        Solicitacao solicitacaoInserida = solicitacaoRepository.save(novaSolicitacao);
        
        return solicitacaoInserida;
    }
}