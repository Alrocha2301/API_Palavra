package com.gft.palavra.dto.palavra;

public class RegistroPalavraDTO {

    private String nome;

    public RegistroPalavraDTO() {
    }

    public RegistroPalavraDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
