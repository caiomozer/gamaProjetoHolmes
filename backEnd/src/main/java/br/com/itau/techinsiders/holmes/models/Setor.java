package br.com.itau.techinsiders.holmes.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Setor implements Serializable {

    private static final long serialVersionUID = -3446966565683527356L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "vlan")
    private String vlan;
    
    @Column(name = "nome_depto")
    private String departamento;

    @Column(name = "ip")
    private String ip;

    // metodos get/set
    public String getVlan() {
        return vlan;
    }
    public void setVlan(String vlan) {
        this.vlan = vlan;
    }

    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    // fim metodos get/set

    public Setor() {
        
    }
}