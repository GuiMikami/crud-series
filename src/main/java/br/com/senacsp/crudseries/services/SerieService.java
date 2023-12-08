package br.com.senacsp.crudseries.services;

import br.com.senacsp.crudseries.models.Serie;
import br.com.senacsp.crudseries.repositories.SerieRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    @Autowired
    public SerieRepository serieRepository;


    public Serie cadastrarSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    public  List<Serie> listarSeriesCadastradas() {
        return serieRepository.findAll();
    }

}
