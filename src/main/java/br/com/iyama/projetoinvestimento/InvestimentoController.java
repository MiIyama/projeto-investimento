package br.com.iyama.projetoinvestimento;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/investimentos")

public class InvestimentoController {

    private List<Investimento> listaInvestimentos = new ArrayList<>();


    @GetMapping
    public ResponseEntity getListaInvestimentos(){
        if (listaInvestimentos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaInvestimentos);
    }

    @PostMapping("/simples")
    public ResponseEntity cadastrarInvestimentoSimples(@RequestBody InvestimentoJurosSimples simples){
        listaInvestimentos.add(simples);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/compostos")
    public ResponseEntity cadastrarInvestimento(@RequestBody InvestimentoJurosCompostos compostos){
        listaInvestimentos.add(compostos);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity selecionarInvestimento(@PathVariable Integer id){
        if (listaInvestimentos.size()>=id){
            return ResponseEntity.ok(listaInvestimentos.get(id-1));
        }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarInvestimento(@PathVariable Integer id){
        if (listaInvestimentos.size()>=id){
            listaInvestimentos.remove(id - 1);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(404).build();
    }

    @GetMapping("/total")
    public ResponseEntity calculaTotal(){
        Double valorTotal=0.0;
        for (Investimento investimento: listaInvestimentos) {
            valorTotal+=investimento.getCalculaValorFuturo();
        }
        return ResponseEntity.ok("Valor total dos investimentos é: R$ "+ String.format("%.2f",valorTotal));
    }

}
