package br.com.saks.SimuladorDeInvestimento.controller;

import br.com.saks.SimuladorDeInvestimento.model.TipoInvestimento;
import br.com.saks.SimuladorDeInvestimento.repository.TipoInvestimentoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/TipoInvestimento")
public class TipoInvestimentoController { 
    
    @Autowired
    private TipoInvestimentoRepository TipoInvestimentoRepository;
    
    @GetMapping
    public List<TipoInvestimento> listarTodos() {
        return TipoInvestimentoRepository.findAll(Sort.by(Sort.Order.asc("status")));
    }
    
    @GetMapping(value="/{id}")
    public Optional<TipoInvestimento> listarPeloId(@PathVariable Long id) {
        return TipoInvestimentoRepository.findById(id);
    }
    
    @PostMapping
    public TipoInvestimento adicionar(@RequestBody TipoInvestimento TipoInvestimento) {
        TipoInvestimento.setStatus(1);
        return TipoInvestimentoRepository.save(TipoInvestimento);
    }
           
    @PutMapping(value="/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody TipoInvestimento TipoInvestimento) {
        return TipoInvestimentoRepository.findById(id)
                .map(record -> {
                    record.setNome(TipoInvestimento.getNome());
                    record.setRisco(TipoInvestimento.getRisco());
                    record.setObjetivos(TipoInvestimento.getObjetivos());
                    record.setStatus(TipoInvestimento.getStatus());
                    TipoInvestimento TipoInvestimentoUpdated = TipoInvestimentoRepository.save(record);
                    return ResponseEntity.ok().body(TipoInvestimentoUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return TipoInvestimentoRepository.findById(id)
                .map(record-> {
                    TipoInvestimentoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
