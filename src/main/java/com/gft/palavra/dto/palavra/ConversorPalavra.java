package com.gft.palavra.dto.palavra;

import com.gft.palavra.entities.Palavra;

public class ConversorPalavra {

    public static Palavra fromDTO(RegistroPalavraDTO dto) {
        return new Palavra(null, dto.getPalavra());
    }
    public static ConsultaPalavraDTO fromEntidade(Palavra palavra) {
        return new ConsultaPalavraDTO(palavra.getId(), palavra.getPalavra());
    }

}
