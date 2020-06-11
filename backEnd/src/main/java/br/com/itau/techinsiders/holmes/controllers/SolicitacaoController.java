package br.com.itau.techinsiders.holmes.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // METODO NÃO VALIDADO : Forma mais facil? Como usar FK?
    @GetMapping(path = "/inicio/{racf}")
    public Solicitacao listarSolicitacao(@PathVariable("racf") String racf) {
        Optional<Colaborador> optionalColaborador = colaboradorRepository.findColaboradorByRacf(racf);
        if (optionalColaborador.isPresent()) {
            Colaborador colaborador = optionalColaborador.get();
            Optional<Solicitacao> optionalSolicitacao = solicitacaoRepository.findAllByColaborador(colaborador);
            return optionalSolicitacao.get();
        }
        return null;
    }
}