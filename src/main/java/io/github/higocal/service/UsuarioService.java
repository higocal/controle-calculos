package io.github.higocal.service;

import io.github.higocal.domain.entity.Usuario;
import io.github.higocal.dto.UsuarioDTO;

public interface UsuarioService {
    Usuario salvar(UsuarioDTO dto);
}
