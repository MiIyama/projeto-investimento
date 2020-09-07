package br.com.iyama.projetoinvestimento;

public class JurosCompostos extends Juros{

    public JurosCompostos (String nome, Double valorPresente, Integer prazo, Double taxaJuros) {
        super(nome, valorPresente, prazo, taxaJuros);
    }

    @Override
    public Double getCalculaValorFuturo() {

        Double jurosDecimal = getTaxaJuros()/100;
        Double teste1 = (1+jurosDecimal);
        Double teste2 = Math.pow(teste1,getPrazo());
        Double valorFuturo = getValorPresente()*teste2;
        return valorFuturo;

    }
    @Override
    public String toString() {
        return "JurosCompostos: " + super.toString()+", ValorFuturo=" + getCalculaValorFuturo() + '\'';
    }

}
