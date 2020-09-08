package br.com.iyama.projetoinvestimento;

public class InvestimentoJurosSimples extends Investimento {

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
