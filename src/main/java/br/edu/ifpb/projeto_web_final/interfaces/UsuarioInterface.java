package br.edu.ifpb.projeto_web_final.interfaces;

import br.edu.ifpb.projeto_web_final.objetos.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioInterface extends CrudRepository<Usuario, String> {

}
