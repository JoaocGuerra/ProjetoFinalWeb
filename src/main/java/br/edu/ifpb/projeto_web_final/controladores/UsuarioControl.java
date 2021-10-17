package br.edu.ifpb.projeto_web_final.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioControl {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("login")
    public String login(){
        return "login_form";
    }



}
