package br.com.saks.SimuladorDeInvestimento.controller;

import br.com.saks.SimuladorDeInvestimento.model.Risco;
import br.com.saks.SimuladorDeInvestimento.repository.RiscoRepository;
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
@RequestMapping("/api/risco")
public class RiscoController { 
    
    @Autowired
    private RiscoRepository RiscoRepository;
    
    @Autowired
    private TipoInvestimentoRepository tipoInvestimentoRepository;
    
    @GetMapping
    public List<Risco> listarTodos() {
        return RiscoRepository.findAll();
    }
    
    @GetMapping(value="/{id}")
    public Risco listarPeloId(@PathVariable Long id) {
        Optional<Risco> risco = RiscoRepository.findById(id);
        Risco riscoResponse = risco.get();
        riscoResponse.setTipoInvestimento(tipoInvestimentoRepository.findAll());
        return riscoResponse;
    }
    
    @PostMapping
    public Risco adicionar(@RequestBody Risco Risco) {
        return RiscoRepository.save(Risco);
    }
           
    @PutMapping(value="/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody Risco Risco) {
        return RiscoRepository.findById(id)
                .map(record -> {
                    record.setNome(Risco.getNome());
                    record.setTipoInvestimento(Risco.getTipoInvestimento());
                    Risco RiscoUpdated = RiscoRepository.save(record);
                    return ResponseEntity.ok().body(RiscoUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return RiscoRepository.findById(id)
                .map(record-> {
                    RiscoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
