package br.com.itau.techinsiders.holmes.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solicitacao implements Serializable{
    
    private static final long serialVersionUID = -6836350488839965232L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "colaborador")
    private Colaborador colaborador;

    @Column(name = "setor")
    private Setor novoSetor;

    @Column(name = "justificativa")
    private String justificativa;

    @Column(name = "comando")
    private String comando;

    @Column(name = "data")
    private String data;

    // metodos get/set
    public Colaborador getColaborador() {
        return colaborador;
    }
    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Setor getNovoSetor() {
        return novoSetor;
    }
    public void setNovoSetor(Setor novoSetor) {
        this.novoSetor = novoSetor;
    }

    public String getJustificativa() {
        return justificativa;
    }
    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getComando() {
        return comando;
    }
    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    // fim metodos get/set

    public Solicitacao() {
        
    }
    

}