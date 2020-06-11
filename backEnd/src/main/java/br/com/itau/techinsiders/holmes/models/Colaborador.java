package br.com.itau.techinsiders.holmes.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Colaborador implements Serializable {

    private static final long serialVersionUID = 4100739249410479338L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "racf", unique = true)
    private String racf;

    @Column(name = "funcional", unique = true)
    private String funcional;

    @Column(name = "setor")
    private Setor setor;

    @Column(name = "maquina")
    private Maquina maquina;

    @Column(name = "senha")
    private String senha;

    @Column(name = "foto")
    private String foto;

    // Metodos get/set
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRacf() {
        return racf;
    }
    public void setRacf(String racf) {
        this.racf = racf;
    }

    public String getFuncional() {
        return funcional;
    }
    public void setFuncional(String funcional) {
        this.funcional = funcional;
    }

    public Setor getSetor() {
        return setor;
    }
    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Maquina getMaquina() {
        return maquina;
    }
    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    // fim metodos get/set
    
    // construtor
    public Colaborador() {

    }
    

}