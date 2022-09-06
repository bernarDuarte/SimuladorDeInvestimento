package br.com.saks.SimuladorDeInvestimento.controller;

import br.com.saks.SimuladorDeInvestimento.model.Objetivo;
import br.com.saks.SimuladorDeInvestimento.repository.ObjetivoRepository;
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
@RequestMapping("/api/objetivo")
public class ObjetivoController { 
    
    @Autowired
    private ObjetivoRepository ObjetivoRepository;
    
    @Autowired
    private TipoInvestimentoRepository tipoInvestimentoRepository;
    
    @GetMapping
    public List<Objetivo> listarTodos() {
        return ObjetivoRepository.findAll();
    }
    
    
    @GetMapping(value="/{id}")
    public Optional<Objetivo> listarPeloId(@PathVariable Long id) {
        return ObjetivoRepository.findById(id);
    }
    
    @PostMapping
    public Objetivo adicionar(@RequestBody Objetivo objetivo) {
        return ObjetivoRepository.save(objetivo);
    }
           
    @PutMapping(value="/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody Objetivo Objetivo) {
        return ObjetivoRepository.findById(id)
                .map(record -> {
                    record.setNome(Objetivo.getNome());
                    record.setEntrada(Objetivo.getEntrada());
                    record.setObjetivo(Objetivo.getObjetivo());
                    record.setTipoInvestimento(Objetivo.getTipoInvestimento());
                    record.setUsuario(Objetivo.getUsuario());
                     Objetivo ObjetivoUpdated = ObjetivoRepository.save(record);
                    return ResponseEntity.ok().body(ObjetivoUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return ObjetivoRepository.findById(id)
                .map(record-> {
                    ObjetivoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
