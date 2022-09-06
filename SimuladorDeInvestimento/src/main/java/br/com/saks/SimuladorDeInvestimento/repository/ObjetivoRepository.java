package br.com.saks.SimuladorDeInvestimento.repository;


import br.com.saks.SimuladorDeInvestimento.model.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetivoRepository extends JpaRepository<Objetivo, Long>{
}
