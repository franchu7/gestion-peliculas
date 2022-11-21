package es.uah.clientePeliculasActores.controller;

import es.uah.clientePeliculasActores.model.Actor;
import es.uah.clientePeliculasActores.model.Pelicula;
import es.uah.clientePeliculasActores.paginator.PageRender;
import es.uah.clientePeliculasActores.service.IActoresService;
import es.uah.clientePeliculasActores.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/actores")
public class ActoresController {
    @Autowired
    IActoresService actoresService;

    @GetMapping(value = {"/", "/home", ""})
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/nuevoActor")
    public String nuevo(Model model) {
        model.addAttribute("titulo", "Nuevo actor");
        Actor actor = new Actor();
        model.addAttribute("actor", actor);
        return "actores/formActor";
    }

    /*@GetMapping("/buscarPeliculas")
    public String buscar(Model model) {
        return "peliculas/searchPelicula";
    }*/

    @GetMapping("/listadoActores")
    public String listadoActores(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Actor> listado = actoresService.buscarTodos(pageable);
        PageRender<Actor> pageRender = new PageRender<Actor>("/actores/listadoActores", listado);
        model.addAttribute("titulo", "Listado de todos los actores");
        model.addAttribute("listadoActores", listado);
        model.addAttribute("page", pageRender);
        return "actores/listActor";
    }

    @GetMapping("/idactor/{id}")
    public String buscarActorPorId(Model model, @PathVariable("id") Integer id) {
        Actor actor = actoresService.buscarActorPorId(id);
        model.addAttribute("pelicula", actor);
        return "actores/formActor";
    }

    /*@GetMapping("/titulo")
    public String buscarActoresPorPais(Model model, @RequestParam(name="page", defaultValue="0") int page, @RequestParam("titulo") String titulo) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Pelicula> listado;
        if (titulo.equals("")) {
            listado = peliculasService.buscarTodos(pageable);
        } else {
            listado = peliculasService.buscarPeliculasPorTitulo(titulo, pageable);
        }
        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/listado", listado);
        model.addAttribute("titulo", "Listado de peliculas por titulo");
        model.addAttribute("listadoPeliculas", listado);
        model.addAttribute("page", pageRender);
        return "peliculas/listPelicula";
    }*/


    @PostMapping("/guardarActor/")
    public String guardarActor(Model model, Actor actor, RedirectAttributes attributes) {
        actoresService.guardarActor(actor);
        model.addAttribute("titulo", "Nuevo actor");
        attributes.addFlashAttribute("msg", "Los datos del actor fueron guardados!");
        return "redirect:/actores/listadoActores";
    }

    @GetMapping("/editarActor/{id}")
    public String editarActor(Model model, @PathVariable("id") Integer id) {
        Actor actor = actoresService.buscarActorPorId(id);
        model.addAttribute("titulo", "Editar actor");
        model.addAttribute("actor", actor);
        return "actores/formActor";
    }

    @GetMapping("/borrarActor/{id}")
    public String eliminarActor(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        actoresService.eliminarActor(id);
        attributes.addFlashAttribute("msg", "Los datos del actor fueron borrados!");
        return "redirect:/actores/listadoActores";
    }
}
