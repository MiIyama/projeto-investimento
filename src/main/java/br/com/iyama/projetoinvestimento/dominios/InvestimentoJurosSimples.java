package br.com.iyama.projetoinvestimento.dominios;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InvestimentoJurosSimples extends Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public InvestimentoJurosSimples() {

    }

    public InvestimentoJurosSimples(String nome, Double valorPresente, Integer prazo, Double taxaJuros) {
        super(nome, valorPresente, prazo, taxaJuros);
    }

    @Override
    public Double getCalculaValorFuturo() {
        Double jurosDecimal = getTaxaJuros()/100;
        Double valorFuturo = getValorPresente()*(1+jurosDecimal*getPrazo());
        return valorFuturo;
    }

    @Override
    public String toString() {
        return "InvestimentoJurosCompostos: " + super.toString()+", ValorFuturo=" + getCalculaValorFuturo() + '\'';
    }
}
