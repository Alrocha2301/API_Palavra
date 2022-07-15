package com.gft.palavra.services;

import com.gft.palavra.entities.Etiqueta;
import com.gft.palavra.entities.Palavra;
import com.gft.palavra.exceptions.EntidadeNaoEncontradaException;
import com.gft.palavra.repositories.EtiquetaRepository;
import com.gft.palavra.repositories.PalavraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PalavraService {

    @Autowired
    private PalavraRepository palavraRepository;

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    public Palavra salvarPalavra(Palavra palavra) {
        return palavraRepository.save(palavra);
    }

    public List<Palavra> listarTodasAsPalavras() {
        return palavraRepository.findAll();
    }

    public Palavra buscarPalavraPorId(Long id) {
        Optional<Palavra> palavra = palavraRepository.findById(id);

        return palavra.orElseThrow(() -> new EntidadeNaoEncontradaException("Palavra não encontrada!"));
    }

    public Palavra buscarPalavraPorNome(String nomePalavra) {
        Optional<Palavra> palavra = palavraRepository.findByNome(nomePalavra);

        return palavra.orElseThrow(() -> new EntidadeNaoEncontradaException("Palavra não encontrada!"));
    }

    public Palavra atualizarPalavra(Palavra palavra, Long id) {
        Palavra palavraOriginal = this.buscarPalavraPorId(id);
        palavra.setId(palavraOriginal.getId());

        return palavraRepository.save(palavra);
    }

    public void excluirPalavra(Long id) {
        palavraRepository.deleteById(id);
    }

    public Palavra adicionarEtiqueta(Long idPalavra, Long idEtiqueta, List<Etiqueta> listaEtiquetas) {
        Palavra palavra = this.buscarPalavraPorId(idPalavra);

        Optional<Etiqueta> etiqueta = etiquetaRepository.findById(idEtiqueta);
        listaEtiquetas.add(etiqueta.get());

        palavra.setListaEtiquetas(listaEtiquetas);

        return palavraRepository.save(palavra);
    }

}

