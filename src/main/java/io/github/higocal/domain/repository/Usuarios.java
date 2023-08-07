package io.github.higocal.domain.repository;

import io.github.higocal.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface Usuarios extends JpaRepository<Usuario, Integer > {

    @Query(value=" select * from usuario u where u.id =:id ", nativeQuery = true)
    Optional<Usuario> findById(@Param("id") Integer id );


 //   @Query(" delete from Usuario c where c.nome =:nome ")
 //   @Modifying
//    void deleteByNome(String nome);

 //   boolean existsByNome(String nome);


}
