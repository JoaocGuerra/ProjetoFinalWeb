package br.edu.ifpb.projeto_web_final.controladores;

import br.edu.ifpb.projeto_web_final.interfaces.SerieInterface;
import br.edu.ifpb.projeto_web_final.interfaces.UsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioControl {
    @Autowired
    private UsuarioInterface ui;

    @Autowired
    private SerieInterface si;


    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("login")
    public String login(){
        return "login_form";
    }

    @RequestMapping("dashboard")
    public String dash(){
        return "dashboard";
    }


}
