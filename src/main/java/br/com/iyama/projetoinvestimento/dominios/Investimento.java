package br.com.iyama.projetoinvestimento.dominios;


import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Investimento {
    private String nome;
    private Double valorPresente;
    private Integer prazo;
    private Double taxaJuros;

    public Investimento() {

    }

    public Investimento(String nome, Double valorPresente, Integer prazo, Double taxaJuros) {
        this.nome = nome;
        this.valorPresente = valorPresente;
        this.prazo = prazo;
        this.taxaJuros = taxaJuros;
    }



    public abstract Double getCalculaValorFuturo();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorPresente() {
        return valorPresente;
    }

    public void setValorPresente(Double valorPresente) {
        this.valorPresente = valorPresente;
    }

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }

    public Double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(Double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    @Override
    public String toString() {
        return "Investimento:" +
                "nome='" + nome + '\'' +
                ", valorPresente=" + valorPresente +
                ", prazo=" + prazo +
                ", taxaJuros=" + taxaJuros ;
    }
}
