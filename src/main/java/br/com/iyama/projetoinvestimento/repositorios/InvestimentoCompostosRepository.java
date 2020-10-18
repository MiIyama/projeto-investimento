package br.com.iyama.projetoinvestimento.repositorios;

import br.com.iyama.projetoinvestimento.dominios.InvestimentoJurosCompostos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentoCompostosRepository extends JpaRepository<InvestimentoJurosCompostos,Integer> {


}
