package br.edu.ifpb.projeto_web_final.controladores;

import br.edu.ifpb.projeto_web_final.interfaces.UsuarioInterface;
import br.edu.ifpb.projeto_web_final.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistroControl {

    @Autowired
    private UsuarioInterface ui;

    @RequestMapping(value = "registrar", method = RequestMethod.GET)
    public String registrar(){
        return "registrar_form";
    }

    @RequestMapping(value = "registrando", method = RequestMethod.POST)
    public String registrar(Usuario usuario){
        ui.save(usuario);

        return "redirect:/registrar";
    }
}
