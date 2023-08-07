package io.github.higocal.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name="despesa")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id_despesa")
    private Integer idDespesa;

    @Column(name = "descricao", length = 100)
    @JsonProperty("descricao_despesa")
    private String descricaoDespesa;

    @Column(name = "data_depesa")
    @Temporal(value = TemporalType.DATE)
    @JsonProperty("data_despesa")
    private Date dataDespesa;

    @JsonProperty("valor_despesa")
    @Column(name = "valor_depesa",precision=19,scale=2)
    private BigDecimal valorDespesa;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
