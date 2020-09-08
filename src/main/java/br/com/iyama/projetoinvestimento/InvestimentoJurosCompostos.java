package br.com.iyama.projetoinvestimento;

public class InvestimentoJurosCompostos extends Investimento {

    public InvestimentoJurosCompostos(String nome, Double valorPresente, Integer prazo, Double taxaJuros) {
        super(nome, valorPresente, prazo, taxaJuros);
    }

    @Override
    public Double getCalculaValorFuturo() {

        Double jurosDecimal = getTaxaJuros()/100;
        Double valorFuturo = getValorPresente()*Math.pow((1+jurosDecimal),getPrazo());
        return valorFuturo;

    }
    @Override
    public String toString() {
        return "InvestimentoJurosCompostos: " + super.toString()+", ValorFuturo=" + getCalculaValorFuturo() + '\'';
    }

}
