package com.gft.palavra.controllers;

import com.gft.palavra.dto.palavra.ConsultaPalavraDTO;
import com.gft.palavra.dto.palavra.ConversorPalavra;
import com.gft.palavra.dto.palavra.RegistroPalavraDTO;
import com.gft.palavra.entities.Palavra;
import com.gft.palavra.services.PalavraService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/palavras")
public class PalavraController {

    private PalavraService palavraService;

    public PalavraController(PalavraService palavraService) {
        this.palavraService = palavraService;
    }

    @GetMapping
    public ResponseEntity<Page<ConsultaPalavraDTO>> listarPalavras(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(palavraService.listarTodasAsPalavras(pageable).map(ConversorPalavra::fromEntidade));
    }

    @PostMapping
    public ResponseEntity<ConsultaPalavraDTO> salvarPalavra(@RequestBody RegistroPalavraDTO dto) {
        Palavra palavra = palavraService.salvarPalavra(ConversorPalavra.fromDTO(dto));

        return ResponseEntity.ok(ConversorPalavra.fromEntidade(palavra));
    }

    @GetMapping("{id}")
    public ResponseEntity<ConsultaPalavraDTO> buscarPalavraPorId(@PathVariable Long id) {

        try {
            Palavra palavra = palavraService.buscarPalavra(id);
            return ResponseEntity.ok(ConversorPalavra.fromEntidade(palavra));
        } catch (RuntimeException ex) {
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
}
