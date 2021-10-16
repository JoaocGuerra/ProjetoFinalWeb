package br.edu.ifpb.projeto_web_final.interfaces;

import br.edu.ifpb.projeto_web_final.entidades.Episodio;
import org.springframework.data.repository.CrudRepository;

public interface EpisodioInterface extends CrudRepository<Episodio, String> {
}
