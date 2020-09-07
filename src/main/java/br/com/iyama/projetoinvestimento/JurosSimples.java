package br.com.iyama.projetoinvestimento;

public class JurosSimples extends Juros{

    public JurosSimples(String nome, Double valorPresente, Integer prazo, Double taxaJuros) {
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
        return "JurosSimples: " + super.toString()+", ValorFuturo=" + getCalculaValorFuturo() + '\'';
    }
}
