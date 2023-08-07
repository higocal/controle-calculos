package io.github.higocal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceitaDTO {

    private String descricaoReceita;
    private Date dataReceita;
    private BigDecimal valorReceita;
}
