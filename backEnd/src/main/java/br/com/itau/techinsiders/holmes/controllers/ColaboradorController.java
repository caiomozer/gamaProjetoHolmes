package br.com.itau.techinsiders.holmes.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.techinsiders.holmes.models.Colaborador;
import br.com.itau.techinsiders.holmes.models.Maquina;
import br.com.itau.techinsiders.holmes.repository.ColaboradorRepository;

@RestController
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    // Método validado!
    @GetMapping(path = "/index/validaColaborador")
    public boolean validaColaborador(@RequestParam("racf") String racf, @RequestParam("senha") String senha) {
        Optional<Colaborador> optionalColaborador = colaboradorRepository.findColaboradorByRacf(racf);
        if (optionalColaborador.isPresent()) {
            Colaborador colaborador = optionalColaborador.get();
            if (colaborador.getSenha().equals(senha)) {
                return true;
            } else {
                System.out.println("Senha incorreta!");
                return false;
            }
        }
        System.out.println("Usuario nao encontrado");
        return false;
    }

    //Metodo validado!
    @GetMapping(path = "/inicio/{racf}")
    public Colaborador dadosColaborador(@PathVariable("racf") String racf) {
        Optional<Colaborador> optionalColaborador = colaboradorRepository.findColaboradorByRacf(racf);
        if(optionalColaborador.isPresent()) {
            Colaborador colaborador = optionalColaborador.get();
            return colaborador;
        } else {
            return null;
        }
        
        
    }

    @PutMapping(path = "/novasolicitacao/atualizaColaborador{id}")
    public Colaborador atualizaColaborador(@PathVariable("id") Long id, @RequestBody Colaborador colaboradorAtualizacao) {
        Optional<Colaborador> optionalColaborador = colaboradorRepository.findById(id);
        if(optionalColaborador.isPresent()) {
            Colaborador colaborador = optionalColaborador.get();
            colaborador.setSetor(colaboradorAtualizacao.getSetor());
            return colaborador;
        } else {
            return null;
        }
    }

    /*

    @PostMapping(path = "/pessoas", consumes = "application/json", produces = "application/json")
    public Colaborador addNovaUsuario(@RequestBody Colaborador novoUsuario) {
        Colaborador pessoaInserida = usuarioRepository.save(novoUsuario); // INSERT
        return pessoaInserida;
    }

    @GetMapping(path = "/pessoas/{id}")
    public Colaborador buscarPessoa(@PathVariable("id") Long idPessoa) {
        Optional<Colaborador> optionalPessoa = usuarioRepository.findById(idPessoa);
        return optionalPessoa.get();
    }

    @GetMapping(path = "/pessoas")
    public Iterable<Colaborador> listarPessoas() {
        Iterable<Colaborador> listaPessoas = usuarioRepository.findAll();
        return listaPessoas;
    }

    /*
    @GetMapping(path = "/pessoas/telefone")
    public Optional<Colaborador> buscarPorTelefone(@RequestParam("numero") String telefone) {
        Optional<Colaborador> pessoa = usuarioRepository.findPessoaByTelefone(telefone);
        return pessoa;
    }
    */

    /*
    @DeleteMapping(path = "/pessoas/{id}")
    public String removerPessoa(@PathVariable("id") Long idPessoa) {
        usuarioRepository.deleteById(idPessoa);
        return "{\"deleted\": \"true\"}";
    }

    
    @PutMapping(path = "/pessoas/{id}")
    public Colaborador atualizarPessoa(@PathVariable Long id, @RequestBody Colaborador pessoaAtualizacao) {
        Optional<Colaborador> optionalPessoa = usuarioRepository.findById(id);

        if (optionalPessoa.isPresent()) {
            // pessoa.get() = pessoaAtualizacao;
            Colaborador pessoa = optionalPessoa.get();
            // pessoa = pessoaAtualizacao;

            pessoa.setNome(pessoaAtualizacao.getNome());
            // pessoa.setTelefone(pessoaAtualizacao.getTelefone());

            Colaborador pessoaSalva = usuarioRepository.save(pessoa);
            return pessoaSalva;

        } else {
            System.out.println("REGISTRO NAO ENCONTRADO!!!!!!!!");
            return null;
        }
        

    }

    */
    

}