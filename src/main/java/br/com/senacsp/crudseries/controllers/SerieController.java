package br.com.senacsp.crudseries.controllers;

import br.com.senacsp.crudseries.models.Serie;
import br.com.senacsp.crudseries.repositories.SerieRepository;
import br.com.senacsp.crudseries.services.SerieService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class SerieController {

    @Autowired
    public SerieService serieService;
    @Autowired
    public SerieRepository serieRepository;
    @RequestMapping(value = "/cadastrarSerie", method = RequestMethod.GET)
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("mensagem", "Preencha o formulário para cadastrar uma nova série.");
        Serie serie = new Serie();
        model.addAttribute("serie", serie);
        return "cadastrarSerie";
    }

    @PostMapping("/cadastrarSerie")
    public ResponseEntity<String> cadastrarSerie(Serie serie) {
        try {
            System.out.println(serie);
            serieService.cadastrarSerie(serie);
            return ResponseEntity.ok().body("Série cadastrada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar a série: " + e.getMessage());
        }
    }
    @GetMapping("/listarSeries")
    public String listarSeries(Model model) {
        List<Serie> series = serieRepository.findAll();
        model.addAttribute("series", series);
        return "listarSeries";
    }
}
