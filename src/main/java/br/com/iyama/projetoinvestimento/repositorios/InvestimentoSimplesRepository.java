package br.com.iyama.projetoinvestimento.repositorios;

import br.com.iyama.projetoinvestimento.dominios.InvestimentoJurosSimples;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentoSimplesRepository extends JpaRepository<InvestimentoJurosSimples,Integer> {



}
