package br.edu.ifpb.projeto_web_final.controladores;

import br.edu.ifpb.projeto_web_final.interfaces.SerieInterface;
import br.edu.ifpb.projeto_web_final.objetos.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Serie_Control {

    @Autowired
    private SerieInterface si;

    @RequestMapping(value = "add_serie", method = RequestMethod.GET)
    public String serie(){
        return "add_serie_form";
    }

    @RequestMapping(value = "serie_added", method = RequestMethod.POST)
    public String serie(Serie serie){
       si.save(serie);


        return "redirect:/add_serie";
    }

}
