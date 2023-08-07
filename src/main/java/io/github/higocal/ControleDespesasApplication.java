package io.github.higocal;

import io.github.higocal.domain.entity.Usuario;
import io.github.higocal.domain.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
    public class ControleDespesasApplication extends SpringBootServletInitializer {

//    @Bean
//    public CommandLineRunner commandLineRunner(@Autowired Usuarios usuarios){
//       return args -> {
//            Usuario u = new Usuario(null, "Fulano");
//           usuarios.save(u);
//
//            Usuario u1 = new Usuario(null, "Dois");
//            usuarios.save(u1);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(ControleDespesasApplication.class, args);
    }
}