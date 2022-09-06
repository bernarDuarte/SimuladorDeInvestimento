package br.com.saks.SimuladorDeInvestimento.repository;

import br.com.saks.SimuladorDeInvestimento.model.TipoInvestimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoInvestimentoRepository extends JpaRepository<TipoInvestimento, Long>{
}
