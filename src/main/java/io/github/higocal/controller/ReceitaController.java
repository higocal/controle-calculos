package io.github.higocal.controller;

import io.github.higocal.domain.entity.Receita;
import io.github.higocal.domain.repository.Receitas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api/receita/")
public class ReceitaController {

    @Autowired
    private Receitas receitas;


    @GetMapping("consultarReceita/{id}")
    public Receita getReceitasById(@PathVariable Integer id){
        return receitas
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Receita não encontrado"));
    }

    @PostMapping("inserirReceita")
    @ResponseStatus(HttpStatus.CREATED)
    public Receita save(@RequestBody Receita receita ){
        return receitas.save(receita);
    }

    @DeleteMapping("deleteReceitas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id ){
        receitas.findById(id)
                .map( receita -> {
                    receitas.delete(receita);
                    return receita;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Receita não encontrado") );

    }


    @PutMapping("atualizaReceitass/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id,
                       @RequestBody Receita receita ) {
        receitas
                .findById(id)
                .map(receitaExistente -> {
                    receita.setIdReceita(receitaExistente.getIdReceita());
                    receitas.save(receita);
                    return receitaExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Receita não encontrado") );
    }

    @GetMapping("lista")
    public ResponseEntity<?> listUsuarios(){
        List<Receita> u = receitas.findAll();

        if (u.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(u);
    }

    @GetMapping("filtro")
    public List<Receita> find( Receita filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return receitas.findAll(example);
    }

}
