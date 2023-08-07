package io.github.higocal.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table( name = "usuario" )
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id_usuario")
    private Integer idUsuario;

    @Column(name = "nome", length = 100)
    @JsonProperty("nome_usuario")
    @NotEmpty(message = "Nome do usuario é obrigatorio")
    private String nomeUsuario;

    @Column(name = "saldo",precision=19,scale=2)
    @JsonProperty("saldo")
    private String saldo;

    @OneToMany( mappedBy = "usuario" , fetch = FetchType.LAZY )
    @JsonIgnore
    private Set<Receita> receita;

    @OneToMany( mappedBy = "usuario" , fetch = FetchType.LAZY )
    @JsonIgnore
    private Set<Despesa> despesa;

}
