package com.gft.palavra.dto.etiqueta;

import com.gft.palavra.entities.Etiqueta;

import java.util.ArrayList;

public class ConversorEtiqueta {

    public static Etiqueta fromDTO(RegistroEtiquetaDTO dto) {
        return new Etiqueta(null, dto.getNome(), new ArrayList<>());
    }

    public static ConsultaEtiquetaDTO fromEntidade(Etiqueta etiqueta) {
        return new ConsultaEtiquetaDTO(etiqueta.getId(), etiqueta.getNome(), etiqueta.getListaPalavras());
    }
}
