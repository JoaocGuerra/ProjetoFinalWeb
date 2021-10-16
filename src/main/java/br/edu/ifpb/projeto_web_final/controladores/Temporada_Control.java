package br.edu.ifpb.projeto_web_final.controladores;

import br.edu.ifpb.projeto_web_final.entidades.Temporada;
import br.edu.ifpb.projeto_web_final.interfaces.TemporadaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Temporada_Control {

    @Autowired
    private TemporadaInterface ti;

    @RequestMapping(value = "add_temporada", method = RequestMethod.GET)
    public String temporada(){
        return "add_temporada_form";
    }

    @RequestMapping(value = "temporada_added", method = RequestMethod.POST)
    public String temporada(Temporada temporada){
        ti.save(temporada);
        return "redirect:/add_temporada";
    }

    @RequestMapping("/list_temporadas")
    public ModelAndView listaTemporadas(){
        ModelAndView mv = new ModelAndView("list_temporada");
        Iterable<Temporada> temporadas = ti.findAll();
        mv.addObject("temporadas", temporadas);
        return mv;
    }
}
