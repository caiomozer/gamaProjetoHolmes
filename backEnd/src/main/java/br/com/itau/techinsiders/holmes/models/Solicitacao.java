package br.com.itau.techinsiders.holmes.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Solicitacao implements Serializable{


    private static final long serialVersionUID = -811123336526315837L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idsolicitacao")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="usuario", referencedColumnName="idcolaborador")
    private Colaborador colaborador;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="novo_depto", referencedColumnName="idsetor")
    private Setor novoSetor;

    @Column(name = "justificativa")
    private String justificativa;

    @Column(name = "comando")
    private String comando;

    @Column(name = "data_solicitacao")
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