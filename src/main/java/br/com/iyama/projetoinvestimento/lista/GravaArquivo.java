package br.com.iyama.projetoinvestimento.lista;

import br.com.iyama.projetoinvestimento.dominios.InvestimentoJurosCompostos;
import br.com.iyama.projetoinvestimento.dominios.InvestimentoJurosSimples;


import java.text.SimpleDateFormat;
import java.util.Date;


public class GravaArquivo {

    String header = String.format("%s;%s;%s;%s;%s;%n", "Nome", "Valor Presente", "Prazo", "TaxaJuros", "Valor Futuro");

    public static String txt(ListaObj<InvestimentoJurosSimples> lista, ListaObj<InvestimentoJurosCompostos> lista2) {
        Date dataDeHoje = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String conteudo = String.format("00INVESTIMENTOS2020%s01%n",formatter.format(dataDeHoje));



        for (int i = 0; i < lista.getTamanho(); i++) {
            InvestimentoJurosSimples listaSimples = lista.getElemento(i);
            conteudo += String.format("01%-50s%9.2f%5d%5.2f%17.2f%n",
                    listaSimples.getNome(),
                    listaSimples.getValorPresente(),
                    listaSimples.getPrazo(),
                    listaSimples.getTaxaJuros(),
                    listaSimples.getCalculaValorFuturo());
        }
        for (int i = 0; i < lista.getTamanho(); i++) {
            InvestimentoJurosCompostos listaComposta = lista2.getElemento(i);
            conteudo += String.format("01%-50s%9.2f%5d%5.2f%17.2f%n",
                    listaComposta.getNome(),
                    listaComposta.getValorPresente(),
                    listaComposta.getPrazo(),
                    listaComposta.getTaxaJuros(),
                    listaComposta.getCalculaValorFuturo());
        }

       conteudo +=  String.format("03%05d",(lista.getTamanho()+lista2.getTamanho()));

        return conteudo;



    }


    public static String csv(ListaObj<InvestimentoJurosSimples> lista, ListaObj<InvestimentoJurosCompostos> lista2) {
        String conteudo = String.format("%s;%s;%s;%s;%s%n", "Nome", "Valor Presente", "Prazo", "TaxaJuros", "Valor Futuro");
        ;

        for (int i = 0; i < lista.getTamanho(); i++) {
            InvestimentoJurosSimples listaSimples = lista.getElemento(i);
            conteudo += String.format("%s;%f;%d;%f;%.2f;%n",
                    listaSimples.getNome(),
                    listaSimples.getValorPresente(),
                    listaSimples.getPrazo(),
                    listaSimples.getTaxaJuros(),
                    listaSimples.getCalculaValorFuturo());
        }
        for (int i = 0; i < lista.getTamanho(); i++) {
            InvestimentoJurosCompostos listaComposta = lista2.getElemento(i);
            conteudo += String.format("%s;%f;%d;%f;%.2f;%n",
                    listaComposta.getNome(),
                    listaComposta.getValorPresente(),
                    listaComposta.getPrazo(),
                    listaComposta.getTaxaJuros(),
                    listaComposta.getCalculaValorFuturo());
        }

        return conteudo;
    }


}
