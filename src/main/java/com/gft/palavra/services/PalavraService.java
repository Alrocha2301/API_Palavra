package com.gft.palavra.services;

import com.gft.palavra.entities.Palavra;
import com.gft.palavra.exceptions.EntidadeNaoEncontradaException;
import com.gft.palavra.repositories.PalavraRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PalavraService {

    private final PalavraRepository palavraRepository;

    public PalavraService(PalavraRepository palavraRepository) {
        this.palavraRepository = palavraRepository;
    }

    public Palavra salvarPalavra(Palavra palavra) {
        return palavraRepository.save(palavra);
    }

    public Page<Palavra> listarTodasAsPalavras(Pageable pageable) {
        return palavraRepository.findAll(pageable);
    }

    public Palavra buscarPalavra(Long id) {
        Optional<Palavra> palavra = palavraRepository.findById(id);

        return palavra.orElseThrow(() -> new EntidadeNaoEncontradaException("Palavra não encontrada!"));
    }

    public Palavra atualizarPalavra(Palavra palavra, Long id) {
        Palavra palavraOriginal = this.buscarPalavra(id);
        palavra.setId(palavraOriginal.getId());

        return palavraRepository.save(palavra);
    }

    public void excluirPalavra(Long id) {
        Palavra palavra = this.buscarPalavra(id);

        palavraRepository.deleteById(id);
    }
}

