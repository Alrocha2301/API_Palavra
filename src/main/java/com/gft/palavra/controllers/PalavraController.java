package com.gft.palavra.controllers;

import com.gft.palavra.dto.etiqueta.ConversorEtiqueta;
import com.gft.palavra.dto.etiqueta.RegistroEtiquetaDTO;
import com.gft.palavra.dto.palavra.ConsultaPalavraDTO;
import com.gft.palavra.dto.palavra.ConversorPalavra;
import com.gft.palavra.dto.palavra.RegistroPalavraDTO;
import com.gft.palavra.entities.Etiqueta;
import com.gft.palavra.entities.Palavra;
import com.gft.palavra.services.PalavraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/palavras")
public class PalavraController {

    private final PalavraService palavraService;

    public PalavraController(PalavraService palavraService) {
        this.palavraService = palavraService;
    }

    @GetMapping
    public ResponseEntity<List<ConsultaPalavraDTO>> listarPalavras() {
        return ResponseEntity.ok(palavraService.listarTodasAsPalavras().stream().map(ConversorPalavra::fromEntidade).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<ConsultaPalavraDTO> salvarPalavra(@RequestBody RegistroPalavraDTO dto) {
        Palavra palavra = palavraService.salvarPalavra(ConversorPalavra.fromDTO(dto));

        return ResponseEntity.ok(ConversorPalavra.fromEntidade(palavra));
    }

    @GetMapping("{id}")
    public ResponseEntity<ConsultaPalavraDTO> buscarPalavraPorId(@PathVariable Long id) {

        try {
            Palavra palavra = palavraService.buscarPalavraPorId(id);
            return ResponseEntity.ok(ConversorPalavra.fromEntidade(palavra));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<ConsultaPalavraDTO> buscarPalavraPorNome(@PathVariable String nome) {
        try {
            Palavra palavra = palavraService.buscarPalavraPorNome(nome);
            return ResponseEntity.ok(ConversorPalavra.fromEntidade(palavra));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<ConsultaPalavraDTO> alterarPalavra(@PathVariable Long id, @RequestBody RegistroPalavraDTO dto) {
        try {
            Palavra palavra = palavraService.atualizarPalavra(ConversorPalavra.fromDTO(dto), id);
            return ResponseEntity.ok(ConversorPalavra.fromEntidade(palavra));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ConsultaPalavraDTO> excluirPalavra(@PathVariable Long id) {
        try {
            palavraService.excluirPalavra(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<List<Etiqueta>> listarEtiquetasDePalavra(@PathVariable Long id) {
        List<Etiqueta> lista = palavraService.buscarPalavraPorId(id).getListaEtiquetas();

        return ResponseEntity.ok().body(lista);
    }
}
