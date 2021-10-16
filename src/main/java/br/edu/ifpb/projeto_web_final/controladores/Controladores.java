package br.edu.ifpb.projeto_web_final.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Controladores {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("login")
    public String login(){
        return "login_form";
    }


    @RequestMapping("temporada")
    public String temporada(){
        return "add_temporada_form";
    }

    @RequestMapping("episodio")
    public String episodio(){
        return "add_episodio_form";
    }

}
