package br.com.iyama.projetoinvestimento.controladores;

import br.com.iyama.projetoinvestimento.dominios.InvestimentoJurosCompostos;
import br.com.iyama.projetoinvestimento.dominios.InvestimentoJurosSimples;
import br.com.iyama.projetoinvestimento.lista.GravaArquivo;
import br.com.iyama.projetoinvestimento.lista.ListaObj;
import br.com.iyama.projetoinvestimento.repositorios.InvestimentoCompostosRepository;
import br.com.iyama.projetoinvestimento.repositorios.InvestimentoSimplesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco")
public class   ContaInvestimentoController {
    @Autowired
    private InvestimentoCompostosRepository repositoryComposto;

    @Autowired
    private InvestimentoSimplesRepository repositorySimples;



    @GetMapping(value="/txt",produces = {"text/plain"})
    private ResponseEntity txt(){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=relatorio.txt");

        ListaObj<InvestimentoJurosSimples> listaSimples = converterListaObjSimples(repositorySimples.findAll());
        ListaObj<InvestimentoJurosCompostos> listaComposto = converterListaObjComposto(repositoryComposto.findAll());

        return new ResponseEntity(GravaArquivo.txt(listaSimples,listaComposto), headers, HttpStatus.OK);
    }

    @GetMapping(value="/csv",produces = {"text/csv"})
    private ResponseEntity csv(){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=relatorio.csv");

        ListaObj<InvestimentoJurosSimples> listaSimples = converterListaObjSimples(repositorySimples.findAll());
        ListaObj<InvestimentoJurosCompostos> listaComposto = converterListaObjComposto(repositoryComposto.findAll());

        return new ResponseEntity(GravaArquivo.csv(listaSimples,listaComposto), headers, HttpStatus.OK);
    }



    private ListaObj<InvestimentoJurosSimples> converterListaObjSimples(List<InvestimentoJurosSimples> lista){
        ListaObj<InvestimentoJurosSimples> listaObj = new ListaObj<>(lista.size());
        for(InvestimentoJurosSimples simples : lista){
            listaObj.adiciona(simples);
        }
        return listaObj;
    }

    private ListaObj<InvestimentoJurosCompostos> converterListaObjComposto(List<InvestimentoJurosCompostos> lista){
        ListaObj<InvestimentoJurosCompostos> listaObj = new ListaObj<>(lista.size());
        for(InvestimentoJurosCompostos composto : lista){
            listaObj.adiciona(composto);
        }
        return listaObj;
    }


}

