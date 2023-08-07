package io.github.higocal.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.higocal.domain.repository.Receitas;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "receita" )
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id_receita")
    private Integer idReceita;

    @Column(name = "descricao", length = 100)
    @JsonProperty("descricao_receita")
    private String descricaoReceita;

    @Column(name = "data_receita")
    @Temporal(value = TemporalType.DATE)
    @JsonProperty("data_receita")
    private Date dataReceita;

    @Column(name = "valor_receita",precision=19,scale=2)
    @JsonProperty("valor_receita")
    private BigDecimal valorReceita;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "receitas")
    private List<Receita> receitas;

    public List<Receita> getItens() {
        return receitas;
    }

    public void setItens(List<Receita> receitas) {
        this.receitas = receitas;
    }


}
