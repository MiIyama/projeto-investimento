package br.com.iyama.projetoinvestimento;

import java.sql.SQLOutput;

public class App {

    public static void main(String[] args) {

       JurosSimples js = new JurosSimples("1",1000.00,120 ,1.00);

        System.out.println(js.getCalculaValorFuturo());


        JurosCompostos jc = new JurosCompostos("1",1000.00,120 ,1.00);

        System.out.println(jc.getCalculaValorFuturo());

        System.out.println(js);
        System.out.println(jc);

}
}
