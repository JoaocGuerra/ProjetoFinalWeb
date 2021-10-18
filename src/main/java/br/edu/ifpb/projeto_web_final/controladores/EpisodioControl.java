package br.edu.ifpb.projeto_web_final.controladores;

import br.edu.ifpb.projeto_web_final.entidades.Episodio;
import br.edu.ifpb.projeto_web_final.entidades.Temporada;
import br.edu.ifpb.projeto_web_final.interfaces.EpisodioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "edit_episodio{id}", method = RequestMethod.GET)
    public ModelAndView editarEpisodio(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("edit_episodio_form");
        Episodio episodio = ei.findById(id);
        mv.addObject("episodio",episodio);
        return mv;
    }

    @RequestMapping(value = "edit_episodio{id}", method = RequestMethod.POST)
    public String editarEpisodioPost(Episodio episodio){
        Episodio episodio1 = ei.findById(episodio.getId());
        episodio1.setNumero(episodio.getNumero());
        ei.save(episodio1);
        return "redirect:/edit_episodio{id}";
    }

    @RequestMapping("/deletar_episodio")
    public String deletarEpisodio(Long id){
        Episodio episodio = ei.findById(id);
        ei.delete(episodio);
        Temporada temporada = episodio.getTemporada();
        long id_temporada = temporada.getId();
        String id_temporada_s = "" + id_temporada;
        return "redirect:/temporada" + id_temporada_s;
    }

}
