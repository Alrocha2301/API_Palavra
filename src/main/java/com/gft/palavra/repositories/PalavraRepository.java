package com.gft.palavra.repositories;

import com.gft.palavra.entities.Palavra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PalavraRepository extends JpaRepository<Palavra, Long> {

    public Optional<Palavra> findByNome(String nome);

}
