package com.gft.palavra.dto.palavra;

import com.gft.palavra.entities.Palavra;

import java.util.ArrayList;

public class ConversorPalavra {

    public static Palavra fromDTO(RegistroPalavraDTO dto) {
        return new Palavra(null, dto.getNome(), new ArrayList<>());
    }
    public static ConsultaPalavraDTO fromEntidade(Palavra palavra) {
        return new ConsultaPalavraDTO(palavra.getId(), palavra.getNome(), palavra.getListaEtiquetas());
    }

}
