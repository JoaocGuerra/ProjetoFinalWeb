package br.edu.ifpb.projeto_web_final.controladores;

import br.edu.ifpb.projeto_web_final.entidades.Episodio;
import br.edu.ifpb.projeto_web_final.entidades.Serie;
import br.edu.ifpb.projeto_web_final.entidades.Temporada;
import br.edu.ifpb.projeto_web_final.interfaces.EpisodioInterface;
import br.edu.ifpb.projeto_web_final.interfaces.TemporadaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TemporadaControl {

    @Autowired
    private TemporadaInterface ti;

    @Autowired
    private EpisodioInterface ei;

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

    @RequestMapping(value = "/temporada{id}", method = RequestMethod.GET)
    public ModelAndView descricaoTemporada(@PathVariable("id") long id){
        Temporada temporada = ti.findById(id);
        ModelAndView mv = new ModelAndView("list_episodio");
        mv.addObject("temporada", temporada);
        Iterable<Episodio> episodios = ei.findByTemporada(temporada);
        mv.addObject("episodios", episodios);
        return mv;
    }

    @RequestMapping(value = "/temporada{id}", method = RequestMethod.POST)
    public String descricaoTemporadaPost(@PathVariable("id") long id, Episodio episodio){
        Temporada temporada = ti.findById(id);
        episodio.setTemporada(temporada);
        ei.save(episodio);
        return "redirect:/temporada{id}";
    }
}
