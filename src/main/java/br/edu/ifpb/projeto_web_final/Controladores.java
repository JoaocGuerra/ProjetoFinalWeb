package br.edu.ifpb.projeto_web_final;

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

    @RequestMapping("registrar")
    public String registrar(){
        return "registrar_form";
    }

    @RequestMapping("cadastrado")
    public String cadastrado(){
        return "list_serie";
    }

    @RequestMapping("serie")
    public String serie(){
        return "add_serie_form";
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
