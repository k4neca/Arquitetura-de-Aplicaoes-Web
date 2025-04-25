package CaioAlmeida.Av1.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonIgnore
    private Empresa empresa;

}
