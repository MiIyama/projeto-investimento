package br.com.iyama.projetoinvestimento.controladores;



import br.com.iyama.projetoinvestimento.dominios.InvestimentoJurosSimples;
import br.com.iyama.projetoinvestimento.repositorios.InvestimentoSimplesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/investimento-simples")
public class InvestimentoSimplesController {

    @Autowired
    private InvestimentoSimplesRepository repository;

    private List<InvestimentoJurosSimples> listaInvestimentos = new ArrayList<>();

    @GetMapping
    public ResponseEntity getInvestimentos(){
        if (repository.count()>0) {
            return ResponseEntity.ok(repository.findAll());
        }else{
            return ResponseEntity.noContent().build();
        }

    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid InvestimentoJurosSimples simples){
        repository.save(simples);
        return ResponseEntity.created(null).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity selecionar(@PathVariable Integer id){
        Optional<InvestimentoJurosSimples> investimentoOptional = repository.findById(id);//-1

        return ResponseEntity.of(investimentoOptional);
    }






}

