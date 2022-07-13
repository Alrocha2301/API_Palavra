package com.gft.palavra.dto.palavra;

public class RegistroPalavraDTO {

    private String palavra;

    public RegistroPalavraDTO() {
    }

    public RegistroPalavraDTO(String palavra) {
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
}
