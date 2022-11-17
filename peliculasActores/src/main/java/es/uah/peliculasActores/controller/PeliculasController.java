package es.uah.peliculasActores.controller;

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

    @GetMapping("/peliculas/año/{año}")
    public List<Pelicula> buscarPeliculasPorAño(@PathVariable("año") Integer año) {
        return peliculasService.buscarPeliculasPorAño(año);
    }

    @GetMapping("/peliculas/pais/{pais}")
    public List<Pelicula> buscarPeliculasPorPais(@PathVariable("pais") String pais) {
        return peliculasService.buscarPeliculasPorPais(pais);
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
