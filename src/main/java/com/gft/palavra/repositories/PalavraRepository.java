package com.gft.palavra.repositories;

import com.gft.palavra.entities.Palavra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalavraRepository extends JpaRepository<Palavra, Long> {
    Page<Palavra> findAll(Pageable pageable);
}
