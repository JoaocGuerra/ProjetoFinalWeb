package br.edu.ifpb.projeto_web_final.interfaces;

import br.edu.ifpb.projeto_web_final.entidades.Serie;
import org.springframework.data.repository.CrudRepository;

public interface SerieInterface extends CrudRepository<Serie, String> {
}
