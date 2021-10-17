package br.edu.ifpb.projeto_web_final.controladores;

import br.edu.ifpb.projeto_web_final.entidades.Temporada;
import br.edu.ifpb.projeto_web_final.interfaces.SerieInterface;
import br.edu.ifpb.projeto_web_final.entidades.Serie;
import br.edu.ifpb.projeto_web_final.interfaces.TemporadaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SerieControl {

    @Autowired
    private SerieInterface si;

    @Autowired
    private TemporadaInterface ti;

    @RequestMapping(value = "add_serie", method = RequestMethod.GET)
    public String serie(){
        return "add_serie_form";
    }

    @RequestMapping(value = "serie_added", method = RequestMethod.POST)
    public String serie(Serie serie){
       si.save(serie);
        return "redirect:/add_serie";
    }

    @RequestMapping("/list_serie")
    public ModelAndView listaSeries(){
        ModelAndView mv = new ModelAndView("list_serie");
        Iterable<Serie> series = si.findAll();
        mv.addObject("series", series);
        return mv;
    }

    @RequestMapping(value = "/serie{id}", method = RequestMethod.GET)
    public ModelAndView descricaoSerie(@PathVariable("id") long id){
        Serie serie = si.findById(id);
        ModelAndView mv = new ModelAndView("list_temporada");
        mv.addObject("serie", serie);
        Iterable<Temporada> temporadas = ti.findBySerie(serie);
        mv.addObject("temporadas", temporadas);
        return mv;
    }

    @RequestMapping(value = "/serie{id}", method = RequestMethod.POST)
    public String descricaoSeriePost(@PathVariable("id") long id, Temporada temporada){
        Serie serie = si.findById(id);
        temporada.setSerie(serie);
        ti.save(temporada);
        return "redirect:/serie{id}";
    }

}
