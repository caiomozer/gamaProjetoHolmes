package br.com.itau.techinsiders.holmes.models;



public class CriaSolicitacao {
    
    private String colaboradorRacf;
    private Long novoDepartamentoId;
    private String antigoDepartamento;
    private String justificativa;
    private String comando;
    private String data;

    public String getColaboradorRacf() {
        return colaboradorRacf;
    }
    public void setColaboradorRacf(String colaboradorRacf) {
        this.colaboradorRacf = colaboradorRacf;
    }

    public Long getNovoDepartamentoId() {
        return novoDepartamentoId;
    }
    public void setNovoDepartamentoId(Long novoDepartamentoId) {
        this.novoDepartamentoId = novoDepartamentoId;
    }

    public String getAntigoDepartamento() {
        return antigoDepartamento;
    }
    public void setAntigoDepartamento(String antigoDepartamento) {
        this.antigoDepartamento = antigoDepartamento;
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

    public CriaSolicitacao() {
        
    }
}