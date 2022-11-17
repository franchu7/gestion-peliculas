package es.uah.peliculasActores.dao;

import es.uah.peliculasActores.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeliculasDAOImpl implements IPeliculasDAO {

    @Autowired
    IPeliculasJPA peliculasJPA;

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
    public List<Pelicula> buscarPeliculasPorAño(Integer año) {
        return peliculasJPA.findByAño(año);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorPais(String pais) {
        return peliculasJPA.findByPais(pais);
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
