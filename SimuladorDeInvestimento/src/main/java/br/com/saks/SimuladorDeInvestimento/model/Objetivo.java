package br.com.saks.SimuladorDeInvestimento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Objetivo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
        private long id;
    
    @Column(length=100, nullable = false )
        private String nome;
    
    @Column(length=8, nullable = false )
        private Float entrada;
    
    @Column(length=100, nullable = false )
        private Float objetivo;
    
    @ManyToOne
    @JoinColumn(name="tipoInvestimos")
    private TipoInvestimento tipoInvestimento;
    
    @ManyToOne
    @JoinColumn(name="objetivos")
    private Usuario usuario;
    
    @Column(length = 10, nullable = false)
    private int tempo;
    
}
