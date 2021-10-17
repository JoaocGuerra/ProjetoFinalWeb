package br.edu.ifpb.projeto_web_final.controladores;

import br.edu.ifpb.projeto_web_final.entidades.Episodio;
import br.edu.ifpb.projeto_web_final.interfaces.EpisodioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EpisodioControl {

    @Autowired
    private EpisodioInterface ei;

    @RequestMapping("add_episodio")
    public String episodio(){
        return "add_episodio_form";
    }

    @RequestMapping("episodio_added")
    public String episodio(Episodio episodio){
        ei.save(episodio);
        return "redirect:/add_episodio";
    }

    @RequestMapping("/list_episodio")
    public ModelAndView listaEpisodios(){
        ModelAndView mv = new ModelAndView("list_episodio");
        Iterable<Episodio> episodios = ei.findAll();
        mv.addObject("episodios", episodios);
        return mv;
    }
}
