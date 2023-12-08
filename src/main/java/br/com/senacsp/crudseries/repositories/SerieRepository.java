package br.com.senacsp.crudseries.repositories;

import br.com.senacsp.crudseries.models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Integer> {

}
