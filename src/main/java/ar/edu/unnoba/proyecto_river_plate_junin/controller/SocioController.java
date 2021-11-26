package ar.edu.unnoba.proyecto_river_plate_junin.controller;


import ar.edu.unnoba.proyecto_river_plate_junin.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SocioController {

    @Autowired
    private SocioService socioService;

    @GetMapping("/socios")
    public String usuariosView(Model model){
        model.addAttribute("socios",socioService.getSocios());
        return "/socios/sociosView";
    }


}
