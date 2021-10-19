package br.edu.ifpb.projeto_web_final.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Serie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private int n_temporadas;
    private int n_episodios;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Temporada> temporadas;

    public Serie() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public int getN_temporadas() {
        return n_temporadas;
    }

    public void setN_temporadas(int n_temporadas) {
        this.n_temporadas = n_temporadas;
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

    public int getN_episodios() {
        return n_episodios;
    }

    public void setN_episodios(int n_episodios) {
        this.n_episodios = n_episodios;
    }
}
