package com.gft.palavra.dto.palavra;

import com.gft.palavra.entities.Etiqueta;

import java.util.List;

public class RegistroPalavraDTO {

    private String nome;
    private List<Etiqueta> listaEtiquetas;

    public RegistroPalavraDTO() {
    }

    public RegistroPalavraDTO(String nome, List<Etiqueta> listaEtiquetas) {
        this.nome = nome;
        this.listaEtiquetas = listaEtiquetas;
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
