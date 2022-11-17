package es.uah.peliculasActores.service;

import es.uah.peliculasActores.model.Actor;

import java.util.List;

public interface IActoresService {

    List<Actor> buscarTodos();

    Actor buscarActorPorId(Integer idActor);

    List<Actor> buscarActoresPorPais(String pais);

    String guardarActor(Actor actor);

    String eliminarActor(Integer idActor);

    String actualizarActor(Actor actor);

    String asociarPelicula(Integer idActor, Integer idPelicula);
}
