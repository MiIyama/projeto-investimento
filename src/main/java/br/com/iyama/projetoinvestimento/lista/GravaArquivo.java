package br.com.iyama.projetoinvestimento.lista;

import br.com.iyama.projetoinvestimento.dominios.InvestimentoJurosCompostos;
import br.com.iyama.projetoinvestimento.dominios.InvestimentoJurosSimples;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class GravaArquivo {



    public static String txt(ListaObj<InvestimentoJurosSimples> lista,ListaObj<InvestimentoJurosCompostos> lista2){
        return"Arquivo txt";

    }


    public static String csv( ListaObj<InvestimentoJurosSimples> lista,ListaObj<InvestimentoJurosCompostos> lista2){
        String arquivo = "";
        String corpoSimples = "";
        String corpoComposto = "";
        String trailer = "";
        String header = String.format("%s;%s;%s;%s;%s;%n","Nome","Valor Presente","Prazo","TaxaJuros","Valor Futuro");

        for (int i = 0; i < lista.getTamanho(); i++) {
            InvestimentoJurosSimples listaSimples = lista.getElemento(i);
            corpoSimples += String.format("%s;%04f;%-20d;%-15f;%04f;%n",
                    listaSimples.getNome(),
                    listaSimples.getValorPresente(),
                    listaSimples.getPrazo(),
                    listaSimples.getTaxaJuros(),
                    listaSimples.getCalculaValorFuturo());

//            private String nome;
//            private Double valorPresente;
//            private Integer prazo;
//            private Double taxaJuros;
        }

        for (int i = 0; i < lista2.getTamanho(); i++) {
            InvestimentoJurosCompostos listaCompostos = lista2.getElemento(i);
            corpoSimples += String.format("%s;%f;%-20d;%-15f;%.2f;%n",
                    listaCompostos.getNome(),
                    listaCompostos.getValorPresente(),
                    listaCompostos.getPrazo(),
                    listaCompostos.getTaxaJuros(),
                    listaCompostos.getCalculaValorFuturo());

//
        }


        arquivo += header;
        arquivo +=corpoSimples;
        arquivo +=corpoComposto;

        return arquivo;



    }




}
