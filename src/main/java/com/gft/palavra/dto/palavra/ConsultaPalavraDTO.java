package com.gft.palavra.dto.palavra;

import com.gft.palavra.entities.Etiqueta;

import java.util.List;

public class ConsultaPalavraDTO {

    private Long id;
    private String nome;
    private List<Etiqueta> listaEtiquetas;

    public ConsultaPalavraDTO() {
    }

    public ConsultaPalavraDTO(Long id, String nome, List<Etiqueta> listaEtiquetas) {
        this.id = id;
        this.nome = nome;
        this.listaEtiquetas = listaEtiquetas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Etiqueta> getListaEtiquetas() {
        return listaEtiquetas;
    }

    public void setListaEtiquetas(List<Etiqueta> listaEtiquetas) {
        this.listaEtiquetas = listaEtiquetas;
    }
}
