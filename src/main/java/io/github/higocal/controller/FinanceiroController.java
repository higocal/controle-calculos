package io.github.higocal.controller;


import io.github.higocal.domain.entity.Usuario;
import io.github.higocal.dto.UsuarioDTO;
import io.github.higocal.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;



@RestController
@RequestMapping("/api/controleFinanceiro/")
public class FinanceiroController {

    private UsuarioService service;

    public FinanceiroController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody UsuarioDTO dto){
        Usuario usuario = service.salvar(dto);
        return usuario.getIdUsuario();


    }

}