package es.uah.peliculasActores.dao;

import es.uah.peliculasActores.model.Actor;
import es.uah.peliculasActores.model.Pelicula;

import java.util.List;

public interface IPeliculasDAO {

    List<Pelicula> buscarTodos();

    Pelicula buscarPeliculaPorId(Integer idPelicula);

    List<Pelicula> buscarPeliculasPorTitulo(String titulo);

    List<Pelicula> buscarPeliculasPorAnno(Integer anno);

    List<Pelicula> buscarPeliculasPorPais(String pais);

    List<Pelicula> buscarPeliculasPorGenero(String genero);

    List<Pelicula> buscarPeliculasPorActor(String nombreActor);


    void guardarPelicula(Pelicula pelicula);

    void eliminarPelicula(Integer idPelicula);

    void actualizarPelicula(Pelicula pelicula);
}
