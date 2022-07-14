package com.gft.palavra.entities;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_palavras")
public class Palavra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @ManyToMany
    private List<Etiqueta> listaEtiquetas;

    public Palavra() {
    }

    public Palavra(Long id, String nome, List<Etiqueta> listaEtiquetas) {
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
