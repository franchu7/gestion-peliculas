package es.uah.clientePeliculasActores.service;

import es.uah.clientePeliculasActores.model.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IActoresService {
    Page<Actor> buscarTodos(Pageable pageable);

    Actor buscarActorPorId(Integer idActor);

    Page<Actor> buscarActoresPorPais(String pais, Pageable pageable);

    void guardarActor(Actor actor);

    void eliminarActor(Integer idActor);


}
