package es.uah.clientePeliculasActores.service;

import es.uah.clientePeliculasActores.model.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPeliculasService {
    Page<Pelicula> buscarTodos(Pageable pageable);

    Pelicula buscarPeliculaPorId(Integer idPelicula);

    Page<Pelicula> buscarPeliculasPorTitulo(String titulo, Pageable pageable);

    Page<Pelicula> buscarPeliculasPorAnno(Integer anno, Pageable pageable);

    Page<Pelicula> buscarPeliculasPorPais(String pais, Pageable pageable);

    Page<Pelicula> buscarPeliculasPorGenero(String genero, Pageable pageable);

    Page<Pelicula> buscarPeliculasPorActor(String nombreActor, Pageable pageable);

    void guardarPelicula(Pelicula pelicula);

    void eliminarPelicula(Integer idPelicula);
}
