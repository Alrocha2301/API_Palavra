package com.gft.palavra.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_etiquetas")
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany
    private List<Palavra> listaPalavras;

    public Etiqueta() {
    }

    public Etiqueta(Long id, String nome, List<Palavra> listaPalavras) {
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
