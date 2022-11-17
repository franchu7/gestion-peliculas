package es.uah.peliculasActores.service;

import es.uah.peliculasActores.dao.IActoresDAO;
import es.uah.peliculasActores.dao.IPeliculasDAO;
import es.uah.peliculasActores.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActoresServiceImpl implements IActoresService {

    @Autowired
    IActoresDAO actoresDAO;

    @Autowired
    IPeliculasDAO peliculasDAO;

    @Override
    public List<Actor> buscarTodos() {
        return actoresDAO.buscarTodos();
    }

    @Override
    public Actor buscarActorPorId(Integer idActor) {
        return actoresDAO.buscarActorPorId(idActor);
    }

    @Override
    public List<Actor> buscarActoresPorPais(String pais) {
        return actoresDAO.buscarActoresPorPais(pais);
    }

    @Override
    public String guardarActor(Actor actor) {
        if(actoresDAO.buscarActorPorId(actor.getIdActor()) == null){
            actoresDAO.guardarActor(actor);
            return "Actor guardado correctamente";
        }
        return "El actor ya existe";
    }

    @Override
    public String eliminarActor(Integer idActor) {
        if (actoresDAO.buscarActorPorId(idActor)!=null) {
            actoresDAO.eliminarActor(idActor);
            return "Actor eliminado correctamente";
        }
        return "El actor no existe";
    }

    @Override
    public String actualizarActor(Actor actor) {
        if (actoresDAO.buscarActorPorId(actor.getIdActor())!=null) {
            actoresDAO.actualizarActor(actor);
            return "Actor actualizado correctamente";
        }
        return "El actor no existe";
    }

    @Override
    public String asociarPelicula(Integer idActor, Integer idPelicula) {
        if(actoresDAO.buscarActorPorId(idActor) == null) {
            return "El actor no existe";
        }
        if (peliculasDAO.buscarPeliculaPorId(idPelicula) == null) {
            return "La película no existe";
        }
        actoresDAO.asociarPelicula(idActor, idPelicula);
        return "Actor asociado correctamente con la película";
    }
}
