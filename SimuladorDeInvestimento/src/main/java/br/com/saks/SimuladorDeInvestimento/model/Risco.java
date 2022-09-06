package br.com.saks.SimuladorDeInvestimento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Risco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(length=100, nullable = false )
        private String nome;
     
    @JsonIgnore
    @OneToMany(mappedBy = "risco")
    private List<TipoInvestimento> tipoInvestimos;
    
}
