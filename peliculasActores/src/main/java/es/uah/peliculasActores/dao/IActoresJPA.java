package es.uah.peliculasActores.dao;

import es.uah.peliculasActores.model.Actor;
import es.uah.peliculasActores.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActoresJPA extends JpaRepository<Actor, Integer> {

    List<Actor> findByPais(String pais);
}
