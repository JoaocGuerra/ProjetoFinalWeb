package br.edu.ifpb.projeto_web_final.interfaces;

import br.edu.ifpb.projeto_web_final.entidades.Serie;
import br.edu.ifpb.projeto_web_final.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface SerieInterface extends CrudRepository<Serie, String> {
    Serie findById(long id);
    Iterable<Serie> findByUsuario(Usuario usuario);
}
