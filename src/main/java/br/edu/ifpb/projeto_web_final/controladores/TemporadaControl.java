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
    public String temporada(Serie serie, Temporada temporada){
        ti.save(temporada);
        return "redirect:/list_temporadas";
    }

    @RequestMapping("/list_temporadas")
    public ModelAndView listaTemporadas(){
        ModelAndView mv = new ModelAndView("list_temporada");
        Iterable<Temporada> temporadas = ti.findAll();
        mv.addObject("temporadas", temporadas);
        return mv;
    }

    @RequestMapping(value = "edit_temporada{id}", method = RequestMethod.GET)
    public ModelAndView editarTemporada(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("edit_temporada_form");
        Temporada temporada = ti.findById(id);
        mv.addObject("temporada",temporada);
        return mv;
    }

    @RequestMapping(value = "edit_temporada{id}", method = RequestMethod.POST)
    public String editarTemporadaPost(Temporada temporada){
        Temporada temporada1 = ti.findById(temporada.getId());
        temporada1.setNumero(temporada.getNumero());
        ti.save(temporada1);
        return "redirect:/edit_temporada{id}";
    }

    @RequestMapping("/deletar_temporada")
    public String deletarTemporada(Long id){
        Temporada temporada = ti.findById(id);
        ti.delete(temporada);
        Serie serie = temporada.getSerie();
        long id_serie = serie.getId();
        String id_serie_s = "" + id_serie;
        return "redirect:/serie" + id_serie_s;
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
