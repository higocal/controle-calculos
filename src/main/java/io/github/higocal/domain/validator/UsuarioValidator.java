package io.github.higocal.domain.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UsuarioValidator {


    private static final String NOME_CAMPO_NOME_USUARIO = "NOME DO USUARIO";

    public void validate(String nome){

        validateNome(nome);

    }

    public void validateNome(String nome){

        if (nome == null || nome.isEmpty()){
           throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Campo " + NOME_CAMPO_NOME_USUARIO + " não preenchido.");

        }
    }

}
