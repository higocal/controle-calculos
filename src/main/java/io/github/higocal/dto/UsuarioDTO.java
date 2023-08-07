package io.github.higocal.dto;

import io.github.higocal.domain.entity.Despesa;
import io.github.higocal.domain.entity.Receita;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Integer usuario;
    private List<ReceitaDTO> receitas;
    private List<DespesaDTO> despesas;
    private BigDecimal saldo;
}