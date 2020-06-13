package br.com.itau.techinsiders.holmes.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Maquina implements Serializable {
    

    private static final long serialVersionUID = 1586948938388111429L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idmaquina")
    private Long id;

    @Column(name = "numero_de_serie")
    private String numeroSerie;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "numero_conector_rede")
    private String conectorRede;

    // metodos get/set
    public String getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConectorRede() {
        return conectorRede;
    }
    public void setConectorRede(String conectorRede) {
        this.conectorRede = conectorRede;
    }
    // fim metodos get/set

    // Construtor padrão
    public Maquina() {
        
    }
}