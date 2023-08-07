package io.github.higocal.domain.repository;

import io.github.higocal.domain.entity.Receita;
import io.github.higocal.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Receitas extends JpaRepository<Receita, Integer > {

    @Query(value=" select * from receita u where u.id =:id ", nativeQuery = true)
    Optional<Receita> findById(@Param("id") Integer id );

    List<Receita> findByUsuario(Usuario usuario);


}
