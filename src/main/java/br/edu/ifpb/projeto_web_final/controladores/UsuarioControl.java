package br.edu.ifpb.projeto_web_final.controladores;

import br.edu.ifpb.projeto_web_final.entidades.Serie;
import br.edu.ifpb.projeto_web_final.entidades.Temporada;
import br.edu.ifpb.projeto_web_final.entidades.Usuario;
import br.edu.ifpb.projeto_web_final.interfaces.SerieInterface;
import br.edu.ifpb.projeto_web_final.interfaces.UsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioControl {

    @Autowired
    private UsuarioInterface ui;

    @Autowired
    private SerieInterface si;

    @RequestMapping("/")
    public ModelAndView index(){
        return login();
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("login_form");
        return mv;
    }

    @RequestMapping("/logout")
    public String logout(Long id){
        return "login_form";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(Usuario usuario ){
        if (ui.findByEmail(usuario.getEmail())!=null) {
            Usuario usuario1 = ui.findByEmail(usuario.getEmail());
            if(usuario1.getSenha().equals(usuario.getSenha())){
                return logado(usuario1.getId());
            }
            return login();
        }
        else
            return login();
    }

    @RequestMapping(value = "/usu{id}", method = RequestMethod.GET)
    public ModelAndView logado(@PathVariable("id") long id){
        Usuario usuario = ui.findById(id);
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("usuario", usuario);
        return mv;
    }

    @RequestMapping(value = "/usuario{id}", method = RequestMethod.GET)
    public ModelAndView descricaoUsuario(@PathVariable("id") long id){
        Usuario usuario = ui.findById(id);
        ModelAndView mv = new ModelAndView("dashboard2");
        mv.addObject("usuario", usuario);
        Iterable<Serie> series = si.findByUsuario(usuario);
        mv.addObject("series", series);
        return mv;
    }

    @RequestMapping(value = "/usuario{id}", method = RequestMethod.POST)
    public String descricaoUsuarioPost(@PathVariable("id") long id, Serie serie){
        Usuario usuario = ui.findById(id);
        serie.setUsuario(usuario);
        si.save(serie);
        return "redirect:/usuario{id}";
    }

    @RequestMapping("dashboard")
    public String dash(){
        return "dashboard";
    }


}
