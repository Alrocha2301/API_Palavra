package com.gft.palavra.controllers;

import com.gft.palavra.dto.etiqueta.ConsultaEtiquetaDTO;
import com.gft.palavra.dto.etiqueta.ConversorEtiqueta;
import com.gft.palavra.dto.etiqueta.RegistroEtiquetaDTO;
import com.gft.palavra.entities.Etiqueta;
import com.gft.palavra.services.EtiquetaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/etiquetas")
public class EtiquetaController {

    private final EtiquetaService etiquetaService;

    public EtiquetaController(EtiquetaService etiquetaService) {
        this.etiquetaService = etiquetaService;
    }

    @GetMapping
    public ResponseEntity<List<ConsultaEtiquetaDTO>> listarEtiquetas() {
        return ResponseEntity.ok(etiquetaService.listarEtiquetas().stream().map(ConversorEtiqueta::fromEntidade).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<ConsultaEtiquetaDTO> salvarEtiqueta(@RequestBody RegistroEtiquetaDTO dto) {
        Etiqueta etiqueta = etiquetaService.salvarEtiqueta(ConversorEtiqueta.fromDTO(dto));

        return ResponseEntity.ok(ConversorEtiqueta.fromEntidade(etiqueta));
    }

    @GetMapping("{id}")
    public ResponseEntity<ConsultaEtiquetaDTO> buscarEtiquetaPorId(@PathVariable Long id) {

        try{
            Etiqueta etiqueta = etiquetaService.buscarEtiquetaPorId(id);
            return ResponseEntity.ok(ConversorEtiqueta.fromEntidade(etiqueta));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<ConsultaEtiquetaDTO> buscarEtiquetaPorNome(@PathVariable String nome) {

        try{
            Etiqueta etiqueta = etiquetaService.buscarEtiquetaPorNome(nome);
            return ResponseEntity.ok(ConversorEtiqueta.fromEntidade(etiqueta));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<ConsultaEtiquetaDTO> alterarEtiqueta(@PathVariable Long id, @RequestBody RegistroEtiquetaDTO dto) {
        try {
            Etiqueta etiqueta = etiquetaService.atualizarEtiqueta(id, ConversorEtiqueta.fromDTO(dto));
            return ResponseEntity.ok(ConversorEtiqueta.fromEntidade(etiqueta));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ConsultaEtiquetaDTO> excluirPalavra(@PathVariable Long id) {
        try {
            etiquetaService.excluirEtiqueta(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
