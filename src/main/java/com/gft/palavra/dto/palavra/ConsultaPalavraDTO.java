package com.gft.palavra.dto.palavra;

public class ConsultaPalavraDTO {

    private Long id;
    private String palavra;

    public ConsultaPalavraDTO() {
    }

    public ConsultaPalavraDTO(Long id, String palavra) {
        this.id = id;
        this.palavra = palavra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
}
