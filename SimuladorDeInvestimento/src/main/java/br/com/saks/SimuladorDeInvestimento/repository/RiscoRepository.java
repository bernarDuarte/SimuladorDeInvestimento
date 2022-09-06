package br.com.saks.SimuladorDeInvestimento.repository;

import br.com.saks.SimuladorDeInvestimento.model.Risco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiscoRepository extends JpaRepository<Risco, Long>{
}
