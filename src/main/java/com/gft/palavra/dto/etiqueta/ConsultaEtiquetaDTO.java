package com.gft.palavra.dto.etiqueta;

import com.gft.palavra.entities.Palavra;

import java.util.List;

public class ConsultaEtiquetaDTO {

    private Long id;
    private String nome;
    private List<Palavra> listaPalavras;

    public ConsultaEtiquetaDTO() {
    }

    public ConsultaEtiquetaDTO(Long id, String nome, List<Palavra> listaPalavras) {
        this.id = id;
        this.nome = nome;
        this.listaPalavras = listaPalavras;
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

    public List<Palavra> getListaPalavras() {
        return listaPalavras;
    }

    public void setListaPalavras(List<Palavra> listaPalavras) {
        this.listaPalavras = listaPalavras;
    }
}
