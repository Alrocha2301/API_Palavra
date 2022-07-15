package com.gft.palavra.repositories;

import com.gft.palavra.entities.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {

    public Optional<Etiqueta> findByNome(String nome);

}
