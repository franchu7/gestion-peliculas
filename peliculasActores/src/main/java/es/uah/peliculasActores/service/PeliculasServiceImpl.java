package es.uah.peliculasActores.service;

import es.uah.peliculasActores.dao.IPeliculasDAO;
import es.uah.peliculasActores.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculasServiceImpl implements IPeliculasService {

    @Autowired
    IPeliculasDAO peliculasDAO;

    @Override
    public List<Pelicula> buscarTodos() {
        return peliculasDAO.buscarTodos();
    }

    @Override
    public Pelicula buscarPeliculaPorId(Integer idPelicula) {
        return peliculasDAO.buscarPeliculaPorId(idPelicula);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorTitulo(String titulo) {
        return peliculasDAO.buscarPeliculasPorTitulo(titulo);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorAño(Integer año) {
        return peliculasDAO.buscarPeliculasPorAño(año);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorPais(String pais) {
        return peliculasDAO.buscarPeliculasPorPais(pais);
    }

    @Override
    public String guardarPelicula(Pelicula pelicula) {
        if (peliculasDAO.buscarPeliculaPorId(pelicula.getIdPelicula())==null) {
            peliculasDAO.guardarPelicula(pelicula);
            return "Pelicula guardada correctamente";
        }
        return "La película ya existe";
    }

    @Override
    public String actualizarPelicula(Pelicula pelicula) {
        if (peliculasDAO.buscarPeliculaPorId(pelicula.getIdPelicula())!=null) {
            peliculasDAO.actualizarPelicula(pelicula);
            return "Película actualizada correctamente";
        }
        return "La película no existe";
    }

    @Override
    public String eliminarPelicula(Integer idPelicula) {
        if (peliculasDAO.buscarPeliculaPorId(idPelicula)!=null) {
            peliculasDAO.eliminarPelicula(idPelicula);
            return "Pelicula eliminada correctamente";
        }
        return "La película no existe o tiene un reparto de actores";
    }
}
