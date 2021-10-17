package br.edu.ifpb.projeto_web_final.interfaces;

import br.edu.ifpb.projeto_web_final.entidades.Serie;
import br.edu.ifpb.projeto_web_final.entidades.Temporada;
import org.springframework.data.repository.CrudRepository;

public interface TemporadaInterface extends CrudRepository<Temporada, String> {
    Temporada findById(Long Id);
    Iterable<Temporada> findBySerie(Serie serie);
}
