package br.edu.ifpb.projeto_web_final.interfaces;

import br.edu.ifpb.projeto_web_final.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioInterface extends CrudRepository<Usuario, String> {
    Usuario findByEmail(String email);
    Usuario findById(Long id);
}
