package br.com.iyama.projetoinvestimento.controladores;

import br.com.iyama.projetoinvestimento.dominios.InvestimentoJurosCompostos;
import br.com.iyama.projetoinvestimento.repositorios.InvestimentoCompostosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/investimento-composto")
public class InvestimentoCompostoController {

    @Autowired
    private InvestimentoCompostosRepository repository;

    private List<InvestimentoJurosCompostos> listaInvestimentos = new ArrayList<>();

    @GetMapping
    public ResponseEntity getInvestimentos(){
        if (repository.count()>0) {
            return ResponseEntity.ok(repository.findAll());
        }else{
            return ResponseEntity.noContent().build();
        }

    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid InvestimentoJurosCompostos composto){
        repository.save(composto);
        return ResponseEntity.created(null).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity selecionar(@PathVariable Integer id){
        Optional<InvestimentoJurosCompostos> investimentoOptional = repository.findById(id);

       return ResponseEntity.of(investimentoOptional);
    }







}
