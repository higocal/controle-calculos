package io.github.higocal.controller;

import io.github.higocal.domain.entity.Despesa;
import io.github.higocal.domain.entity.Usuario;
import io.github.higocal.domain.repository.Despesas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api/despesa/")
public class DespesaController {

    @Autowired
    private Despesas despesas;


    @GetMapping("consultarDespesa/{id}")
    public Despesa getDespesasById(@PathVariable Integer id){
        return despesas
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Despesa não encontrado"));
    }

    @PostMapping("inserirDespesa")
    @ResponseStatus(HttpStatus.CREATED)
    public Despesa save(@RequestBody Despesa despesa ){
        return despesas.save(despesa);
    }

    @DeleteMapping("deleteDespesas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id ){
        despesas.findById(id)
                .map( despesa -> {
                    despesas.delete(despesa);
                    return despesa;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Despesa não encontrado") );

    }


    @PutMapping("atualizaDespesas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id,
                       @RequestBody Despesa despesa ) {
        despesas
                .findById(id)
                .map(despesaExistente -> {
                    despesa.setIdDespesa(despesaExistente.getIdDespesa());
                    despesas.save(despesa);
                    return despesaExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Despesa não encontrado") );
    }

    @GetMapping("lista")
    public ResponseEntity<?> listUsuarios(){
        List<Despesa> u = despesas.findAll();

        if (u.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(u);
    }

    @GetMapping("filtro")
    public List<Despesa> find( Despesa filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return despesas.findAll(example);
    }

}
