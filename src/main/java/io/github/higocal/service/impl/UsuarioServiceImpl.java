package io.github.higocal.service.impl;

import io.github.higocal.domain.entity.Usuario;
import io.github.higocal.domain.repository.Despesas;
import io.github.higocal.domain.repository.Receitas;
import io.github.higocal.domain.repository.Usuarios;
import io.github.higocal.dto.UsuarioDTO;
import io.github.higocal.exception.RegraNegocioException;
import io.github.higocal.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private Usuarios usuariosRepository;
    private Receitas receitasRepository;
    private Despesas despesasRepository;

    @Override
    @Transactional
    public Usuario salvar(UsuarioDTO dto) {
        Integer idUsuario = dto.getUsuario();
        Usuario usuario = usuariosRepository
                .findById(idUsuario)
                .orElseThrow(() -> new RegraNegocioException("Usuario não econtrado"));
    return usuario;
    }
}
