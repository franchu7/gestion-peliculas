package es.uah.peliculasActores.service;

import es.uah.peliculasActores.model.Actor;
import es.uah.peliculasActores.model.Pelicula;

import java.util.List;

public interface IPeliculasService {

    List<Pelicula> buscarTodos();

    Pelicula buscarPeliculaPorId(Integer idPelicula);

    List<Pelicula> buscarPeliculasPorTitulo(String titulo);

    List<Pelicula> buscarPeliculasPorAnno(Integer anno);

    List<Pelicula> buscarPeliculasPorPais(String pais);

    List<Pelicula> buscarPeliculasPorGenero(String genero);

    List<Pelicula> buscarPeliculasPorActor(String nombreActor);

    String guardarPelicula(Pelicula pelicula);

    String actualizarPelicula(Pelicula pelicula);

    String eliminarPelicula(Integer idPelicula);
}
