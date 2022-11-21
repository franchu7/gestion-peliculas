package es.uah.peliculasActores.controller;

import es.uah.peliculasActores.model.Actor;
import es.uah.peliculasActores.model.Pelicula;
import es.uah.peliculasActores.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculasController {

    @Autowired
    IPeliculasService peliculasService;

    @GetMapping("/peliculas")
    public List<Pelicula> buscarTodos() {
        return peliculasService.buscarTodos();
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula buscarPeliculaPorId(@PathVariable("id") Integer id) {
        return peliculasService.buscarPeliculaPorId(id);
    }

    @GetMapping("/peliculas/titulo/{titulo}")
    public List<Pelicula> buscarPeliculasPorTitulo(@PathVariable("titulo") String titulo) {
        return peliculasService.buscarPeliculasPorTitulo(titulo);
    }

    @GetMapping("/peliculas/anno/{anno}")
    public List<Pelicula> buscarPeliculasPorAnno(@PathVariable("anno") Integer anno) {
        return peliculasService.buscarPeliculasPorAnno(anno);
    }

    @GetMapping("/peliculas/pais/{pais}")
    public List<Pelicula> buscarPeliculasPorPais(@PathVariable("pais") String pais) {
        return peliculasService.buscarPeliculasPorPais(pais);
    }

    @GetMapping("/peliculas/genero/{genero}")
    public List<Pelicula> buscarPeliculasPorGenero(@PathVariable("genero") String genero) {
        return peliculasService.buscarPeliculasPorGenero(genero);
    }

    @GetMapping("/peliculas/actor/{nombreActor}")
    public List<Pelicula> buscarPeliculasPorActor(@PathVariable("nombreActor") String nombreActor) {
        return peliculasService.buscarPeliculasPorActor(nombreActor);
    }

    @PostMapping("/peliculas")
    public void guardarPelicula(@RequestBody Pelicula pelicula) {
        peliculasService.guardarPelicula(pelicula);
    }

    @PutMapping("/peliculas")
    public void actualizarPelicula(@RequestBody Pelicula pelicula) {
        peliculasService.actualizarPelicula(pelicula);
    }

    @DeleteMapping("/peliculas/{id}")
    public void eliminarPelicula(@PathVariable("id") Integer id) {
        peliculasService.eliminarPelicula(id);
    }
}
