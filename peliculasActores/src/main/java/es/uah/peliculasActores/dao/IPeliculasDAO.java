package es.uah.peliculasActores.dao;

import es.uah.peliculasActores.model.Pelicula;

import java.util.List;

public interface IPeliculasDAO {

    List<Pelicula> buscarTodos();

    Pelicula buscarPeliculaPorId(Integer idPelicula);

    List<Pelicula> buscarPeliculasPorTitulo(String titulo);

    List<Pelicula> buscarPeliculasPorAño(Integer año);

    List<Pelicula> buscarPeliculasPorPais(String pais);

    void guardarPelicula(Pelicula pelicula);

    void eliminarPelicula(Integer idPelicula);

    void actualizarPelicula(Pelicula pelicula);
}
