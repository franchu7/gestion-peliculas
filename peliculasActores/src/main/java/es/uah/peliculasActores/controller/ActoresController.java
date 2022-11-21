package es.uah.peliculasActores.controller;

import es.uah.peliculasActores.model.Actor;
import es.uah.peliculasActores.service.IActoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActoresController {

    @Autowired
    IActoresService actoresService;

    @GetMapping("/actores")
    public List<Actor> buscarTodos() {
        return actoresService.buscarTodos();
    }

    @GetMapping("/actores/{id}")
    public Actor buscarActorPorId(@PathVariable("id") Integer id) {
        return actoresService.buscarActorPorId(id);
    }

    @GetMapping("/actores/pais/{pais}")
    public List<Actor> buscarActoresPorPais(@PathVariable("pais") String pais) {
        return actoresService.buscarActoresPorPais(pais);
    }

    @PostMapping("/actores")
    public void guardarActor(@RequestBody Actor actor) {

        actoresService.guardarActor(actor);
    }

    @PutMapping("/actores")
    public void actualizarActor(@RequestBody Actor actor) {
        actoresService.actualizarActor(actor);
    }

    @DeleteMapping("/actores/{id}")
    public String eliminarActor(@PathVariable("id") Integer id) {
        return actoresService.eliminarActor(id);
    }

    @GetMapping("/actores/asoc/{ida}/{idp}")
    public void asociarPelicula(@PathVariable("ida") Integer ida, @PathVariable("idp") Integer idp) {
        actoresService.asociarPelicula(ida, idp);
    }
}
