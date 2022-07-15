package com.gft.palavra.services;

import com.gft.palavra.entities.Etiqueta;
import com.gft.palavra.exceptions.EntidadeNaoEncontradaException;
import com.gft.palavra.repositories.EtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtiquetaService {

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    public Etiqueta salvarEtiqueta(Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    public List<Etiqueta> listarEtiquetas() {
        return etiquetaRepository.findAll();
    }

    public Etiqueta buscarEtiquetaPorId(Long id) {
        Optional<Etiqueta> etiqueta = etiquetaRepository.findById(id);

        return etiqueta.orElseThrow(() -> new EntidadeNaoEncontradaException("Etiqueta não encontrada!"));
    }

    public Etiqueta buscarEtiquetaPorNome(String nomeEtiqueta) {
        Optional<Etiqueta> etiqueta = etiquetaRepository.findByNome(nomeEtiqueta);

        return etiqueta.get();
    }

    public Etiqueta atualizarEtiqueta(Long id, Etiqueta etiqueta) {
        Etiqueta etiquetaOriginal = this.buscarEtiquetaPorId(id);
        etiqueta.setId(etiquetaOriginal.getId());

        return etiquetaRepository.save(etiqueta);
    }

    public void excluirEtiqueta(Long id) {
        etiquetaRepository.deleteById(id);
    }
}
