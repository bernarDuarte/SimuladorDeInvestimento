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
public class TipoInvestimento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false)
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "risco_investimento")
    private Risco risco;
    
    @JsonIgnore
    @OneToMany(mappedBy="tipoInvestimento")
    private List<Objetivo> objetivos;
    
    @Column(nullable = false)
    private Double rendimento;
    
    @Column(nullable = false)
    private int status;
    
}
