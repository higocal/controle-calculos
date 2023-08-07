package io.github.higocal.controller;

import io.github.higocal.domain.entity.Usuario;
import io.github.higocal.domain.repository.Usuarios;
import io.github.higocal.domain.validator.UsuarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/")
public class UsuariosController {

    @Autowired
    private Usuarios usuarios;

    @Autowired
    UsuarioValidator usuarioValidator;

    @GetMapping("consulta/{id}")
    public Usuario getUsuarioById(@PathVariable Integer id){
        return usuarios
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Usuario não encontrado"));
    }

    @PostMapping("inserirUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody  @Valid Usuario usuario ){
//        usuarioValidator.validate(usuario.getNomeUsuario());
        return usuarios.save(usuario);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id ){
         usuarios.findById(id)
                 .map( usuario -> {
                     usuarios.delete(usuario);
                    return usuario;
                 })
                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                         "Cliente não encontrado") );

    }


    @PutMapping("atualiza/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id,
                       @RequestBody Usuario usuario ) {
        usuarios
                .findById(id)
                .map(usuarioExistente -> {
                    usuario.setIdUsuario(usuarioExistente.getIdUsuario());
                    usuarios.save(usuario);
                    return usuarioExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado") );
    }

    @GetMapping("lista")
    public ResponseEntity<?> listUsuarios(){
        List<Usuario> u = usuarios.findAll();

        if (u.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(u);
    }

    @GetMapping("filtro")
    public List<Usuario> find( Usuario filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return usuarios.findAll(example);
    }

}