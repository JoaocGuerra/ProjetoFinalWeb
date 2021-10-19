package br.edu.ifpb.projeto_web_final.entidades;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Temporada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int numero;
    private int n_episodios;

    @ManyToOne
    private Serie serie;

    @OneToMany(mappedBy = "temporada", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Episodio> episodios;

    public Temporada() {
    }

    public Temporada(int numero, int n_episodios, Serie serie) {
        this.numero = numero;
        this.n_episodios = n_episodios;
        this.serie = serie;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    public int getNumero() {
        return numero;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getN_episodios() {
        return n_episodios;
    }

    public void setN_episodios(int n_episodios) {
        this.n_episodios = n_episodios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
