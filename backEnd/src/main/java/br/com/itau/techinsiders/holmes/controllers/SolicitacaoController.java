package br.com.itau.techinsiders.holmes.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.techinsiders.holmes.models.Solicitacao;
import br.com.itau.techinsiders.holmes.models.CriaSolicitacao;
import br.com.itau.techinsiders.holmes.models.Colaborador;
import br.com.itau.techinsiders.holmes.models.Departamento;
import br.com.itau.techinsiders.holmes.repository.ColaboradorRepository;
import br.com.itau.techinsiders.holmes.repository.SolicitacaoRepository;
import br.com.itau.techinsiders.holmes.repository.DepartamentoRepository;

@RestController
public class SolicitacaoController {

    
    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;
    
    // validado ok!
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
    public Solicitacao addSolicitacao(@RequestBody CriaSolicitacao novaSolicitacao) {
        Optional<Colaborador> optionalColaborador = colaboradorRepository.findColaboradorByRacf(novaSolicitacao.getColaboradorRacf());
        Optional<Departamento> optionalDepartamentoAntigo = departamentoRepository.findDepartamentoByDepartamento(novaSolicitacao.getAntigoDepartamento());
        Optional<Departamento> optionalDepartamentoNovo = departamentoRepository.findById(novaSolicitacao.getNovoDepartamentoId());
        if(optionalColaborador.isPresent() && optionalDepartamentoAntigo.isPresent() && optionalDepartamentoNovo.isPresent()) {
            Solicitacao solicitacao = new Solicitacao();
            solicitacao.setColaborador(optionalColaborador.get());
            solicitacao.setAntigoDepartamento(optionalDepartamentoAntigo.get());
            solicitacao.setNovoDepartamento(optionalDepartamentoNovo.get());
            solicitacao.setJustificativa(novaSolicitacao.getJustificativa());
            
            String comando = "switchport vlan "+optionalDepartamentoAntigo.get().getVlan()+"; interface range 8320A "+optionalDepartamentoNovo.get().getVlan()+"; exit";
            
            solicitacao.setComando(comando);
            solicitacao.setData(novaSolicitacao.getData());
            
            Colaborador colaborador = optionalColaborador.get();
            colaborador.setDepartamento(optionalDepartamentoNovo.get());
            
            Solicitacao solicitacaoInserida = solicitacaoRepository.save(solicitacao);
            return solicitacaoInserida;
        } else {
            return null;
        }
        
        
        
    }
}