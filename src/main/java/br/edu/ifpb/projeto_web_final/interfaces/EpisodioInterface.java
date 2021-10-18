package br.edu.ifpb.projeto_web_final.interfaces;

import br.edu.ifpb.projeto_web_final.entidades.Episodio;
import br.edu.ifpb.projeto_web_final.entidades.Temporada;
import org.springframework.data.repository.CrudRepository;

public interface EpisodioInterface extends CrudRepository<Episodio, String> {
    Episodio findById(Long id);
    Iterable<Episodio> findByTemporada(Temporada temporada);
}
