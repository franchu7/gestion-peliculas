package es.uah.peliculasActores.dao;

import es.uah.peliculasActores.model.Actor;
import es.uah.peliculasActores.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPeliculasJPA extends JpaRepository<Pelicula, Integer> {

    List<Pelicula> findByTitulo(String titulo);

    List<Pelicula> findByAnno(Integer anno);

    List<Pelicula> findByPais(String pais);

    List<Pelicula> findByGenero(String genero);



}
