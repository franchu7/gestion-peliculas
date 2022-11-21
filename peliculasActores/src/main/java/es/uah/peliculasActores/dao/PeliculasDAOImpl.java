package es.uah.peliculasActores.dao;

import es.uah.peliculasActores.model.Actor;
import es.uah.peliculasActores.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PeliculasDAOImpl implements IPeliculasDAO {

    @Autowired
    IPeliculasJPA peliculasJPA;
    @Autowired
    IActoresJPA actoresJPA;

    @Override
    public List<Pelicula> buscarTodos() {
        return peliculasJPA.findAll();
    }

    @Override
    public Pelicula buscarPeliculaPorId(Integer idPelicula) {
        Optional<Pelicula> optional = peliculasJPA.findById(idPelicula);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Pelicula> buscarPeliculasPorTitulo(String titulo) {
        return peliculasJPA.findByTitulo(titulo);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorAnno(Integer anno) {
        return peliculasJPA.findByAnno(anno);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorPais(String pais) {
        return peliculasJPA.findByPais(pais);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorGenero(String genero) {
        return peliculasJPA.findByGenero(genero);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorActor(String nombreActor) {

        List<Actor> actores = actoresJPA.findByNombre(nombreActor);

        if (actores.size() > 0) {
            return actores.get(0).getPeliculas();
        }
        return new ArrayList<>();
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        peliculasJPA.save(pelicula);
    }

    @Override
    public void eliminarPelicula(Integer idPelicula) {
        peliculasJPA.deleteById(idPelicula);
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        peliculasJPA.save(pelicula);
    }

}
