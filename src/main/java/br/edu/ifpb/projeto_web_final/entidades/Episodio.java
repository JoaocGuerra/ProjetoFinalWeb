package br.edu.ifpb.projeto_web_final.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Episodio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int numero;

    @ManyToOne
    private Temporada temporada;

    private boolean assistiu = false;

    public Temporada getTemporada() {
        return temporada;
    }

    public boolean isAssistiu() {
        return assistiu;
    }

    public void setAssistiu(boolean assistiu) {
        this.assistiu = assistiu;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
