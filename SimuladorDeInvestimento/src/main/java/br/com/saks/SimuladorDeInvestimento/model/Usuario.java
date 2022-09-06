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
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false,length = 100)
    private String nome;
    
    @Column(nullable = false, length=150)
    private String email;
    
    @Column(nullable = false, length=50)
    private String senha;
        
    @JsonIgnore
    @OneToMany(mappedBy="usuario")
    private List<Objetivo> objetivos;

    @Column(nullable = false, length=11)
    private String telefone;
    
    @Column(nullable = false)
    private int status;
}
