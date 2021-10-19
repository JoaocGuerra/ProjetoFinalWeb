package br.edu.ifpb.projeto_web_final.controladores;

import br.edu.ifpb.projeto_web_final.entidades.Episodio;
import br.edu.ifpb.projeto_web_final.entidades.Temporada;
import br.edu.ifpb.projeto_web_final.entidades.Usuario;
import br.edu.ifpb.projeto_web_final.interfaces.EpisodioInterface;
import br.edu.ifpb.projeto_web_final.interfaces.SerieInterface;
import br.edu.ifpb.projeto_web_final.entidades.Serie;
import br.edu.ifpb.projeto_web_final.interfaces.TemporadaInterface;
import br.edu.ifpb.projeto_web_final.interfaces.UsuarioInterface;
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
    private UsuarioInterface ui;

    @Autowired
    private SerieInterface si;

    @Autowired
    private TemporadaInterface ti;

    @Autowired
    private EpisodioInterface ei;

    @RequestMapping(value = "add_serie", method = RequestMethod.GET)
    public String serie(){
        return "add_serie_form";
    }

    @RequestMapping(value = "serie_added", method = RequestMethod.POST)
    public String serie(Usuario usuario, Serie serie){
        serie.setUsuario(usuario);
        Serie serie1 = new Serie();
        serie1.setUsuario(usuario);
        serie1.setNome(serie.getNome());
        serie1.setN_temporadas(serie.getN_temporadas());
        serie1.setN_episodios(serie.getN_episodios());
        si.save(serie1);
        Temporada temporada = null;
        Episodio episodio;
        int n_episodios;
        int n_temporadas = serie.getN_temporadas();
        for (int i = 0; i < n_temporadas; i++){
            temporada = new Temporada();
            temporada.setNumero(i+1);
            temporada.setN_episodios(serie1.getN_episodios());
            temporada.setSerie(serie1);
            ti.save(temporada);
            n_episodios = temporada.getN_episodios();
            for (int j = 0; j < n_episodios; j++){
                episodio = new Episodio();
                episodio.setNumero(j+1);
                episodio.setAssistiu(false);
                episodio.setTemporada(temporada);
                ei.save(episodio);
            }
        }
        return "redirect:/list_serie";
    }

    @RequestMapping(value = "edit_serie{id}", method = RequestMethod.GET)
    public ModelAndView editarSerie(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("edit_serie_form");
        Serie serie = si.findById(id);
        mv.addObject("serie",serie);
        return mv;
    }

    @RequestMapping(value = "edit_serie{id}", method = RequestMethod.POST)
    public String editarSeriePost(Serie serie){
        Serie serie1 = si.findById(serie.getId());
        serie1.setNome(serie.getNome());
        si.save(serie1);
        return "redirect:/edit_serie{id}";
    }

    @RequestMapping("/list_serie")
    public ModelAndView listaSeries(){
        ModelAndView mv = new ModelAndView("list_serie");
        Iterable<Serie> series = si.findAll();
        mv.addObject("series", series);
        return mv;
    }

    @RequestMapping("/deletar_serie")
    public String deletarSerie(Long id){
        Serie serie = si.findById(id);
        si.delete(serie);
        Usuario usuario = serie.getUsuario();
        long id_usuario = usuario.getId();
        String id_usuario_s = "" + id_usuario;
        return "redirect:/usuario" + id_usuario_s;
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
