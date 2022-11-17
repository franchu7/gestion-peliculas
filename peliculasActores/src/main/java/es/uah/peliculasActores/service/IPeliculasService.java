package es.uah.peliculasActores.service;

import es.uah.peliculasActores.model.Pelicula;

import java.util.List;

public interface IPeliculasService {

    List<Pelicula> buscarTodos();

    Pelicula buscarPeliculaPorId(Integer idPelicula);

    List<Pelicula> buscarPeliculasPorTitulo(String titulo);

    List<Pelicula> buscarPeliculasPorAño(Integer año);

    List<Pelicula> buscarPeliculasPorPais(String pais);

    String guardarPelicula(Pelicula pelicula);

    String actualizarPelicula(Pelicula pelicula);

    String eliminarPelicula(Integer idPelicula);
}
