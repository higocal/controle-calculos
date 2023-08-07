package io.github.higocal.domain.repository;

import io.github.higocal.domain.entity.Despesa;
import io.github.higocal.domain.entity.Receita;
import io.github.higocal.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Despesas extends JpaRepository<Despesa, Integer > {

    @Query(value=" select * from despesa u where u.id =:id ", nativeQuery = true)
    Optional<Despesa> findById(@Param("id") Integer id );

    List<Despesa> findByUsuario(Usuario usuario);

}
