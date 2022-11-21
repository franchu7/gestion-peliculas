package es.uah.clientePeliculasActores.controller;

import es.uah.clientePeliculasActores.model.Pelicula;
import es.uah.clientePeliculasActores.paginator.PageRender;
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
@RequestMapping("/peliculas")
public class PeliculasController {
    @Autowired
    IPeliculasService peliculasService;

    @GetMapping(value = {"/", "/home", ""})
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/nuevaPelicula")
    public String nuevo(Model model) {
        model.addAttribute("titulo", "Nueva pelicula");
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        return "peliculas/formPelicula";
    }

    @GetMapping("/buscarPeliculas")
    public String buscar(Model model) {
        return "peliculas/searchPelicula";
    }

    @GetMapping("/listado")
    public String listadoPeliculas(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Pelicula> listado = peliculasService.buscarTodos(pageable);
        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/peliculas/listado", listado);
        model.addAttribute("titulo", "Listado de todas las peliculas");
        model.addAttribute("listadoPeliculas", listado);
        model.addAttribute("page", pageRender);
        return "peliculas/listPelicula";
    }

    @GetMapping("/idpelicula/{id}")
    public String buscarPeliculaPorId(Model model, @PathVariable("id") Integer id) {
        Pelicula pelicula = peliculasService.buscarPeliculaPorId(id);
        model.addAttribute("pelicula", pelicula);
        return "peliculas/formPelicula";
    }

    @GetMapping("/titulo")
    public String buscarPeliculasPorTitulo(Model model, @RequestParam(name="page", defaultValue="0") int page, @RequestParam("titulo") String titulo) {
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
    }

    @GetMapping("/anno")
    public String buscarPeliculasPorAnno(Model model, @RequestParam(name="page", defaultValue="0") int page, @RequestParam("anno") Integer anno) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Pelicula> listado;
        if (anno == null) {
            listado = peliculasService.buscarTodos(pageable);
        } else {
            listado = peliculasService.buscarPeliculasPorAnno(anno, pageable);
        }
        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/listado", listado);
        model.addAttribute("titulo", "Listado de peliculas por año");
        model.addAttribute("listadoPeliculas", listado);
        model.addAttribute("page", pageRender);
        return "peliculas/listPelicula";
    }

    @GetMapping("/pais")
    public String buscarPeliculasPorPais(Model model, @RequestParam(name="page", defaultValue="0") int page, @RequestParam("pais") String pais) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Pelicula> listado;
        if (pais.equals("")) {
            listado = peliculasService.buscarTodos(pageable);
        } else {
            listado = peliculasService.buscarPeliculasPorPais(pais, pageable);
        }
        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/listado", listado);
        model.addAttribute("titulo", "Listado de peliculas por pais");
        model.addAttribute("listadoPeliculas", listado);
        model.addAttribute("page", pageRender);
        return "peliculas/listPelicula";
    }

    @GetMapping("/genero")
    public String buscarPeliculasPorGenero(Model model, @RequestParam(name="page", defaultValue="0") int page, @RequestParam("genero") String genero) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Pelicula> listado;
        if (genero.equals("")) {
            listado = peliculasService.buscarTodos(pageable);
        } else {
            listado = peliculasService.buscarPeliculasPorGenero(genero, pageable);
        }
        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/listado", listado);
        model.addAttribute("titulo", "Listado de peliculas por genero");
        model.addAttribute("listadoPeliculas", listado);
        model.addAttribute("page", pageRender);
        return "peliculas/listPelicula";
    }

    @GetMapping("/actor")
    public String buscarPeliculasPorActor(Model model, @RequestParam(name="page", defaultValue="0") int page, @RequestParam("actor") String actor) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Pelicula> listado;
        if (actor.equals("")) {
            listado = peliculasService.buscarTodos(pageable);
        } else {
            listado = peliculasService.buscarPeliculasPorActor(actor, pageable);
        }
        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/listado", listado);
        model.addAttribute("titulo", "Listado de peliculas por actor");
        model.addAttribute("listadoPeliculas", listado);
        model.addAttribute("page", pageRender);
        return "peliculas/listPelicula";
    }

    @PostMapping("/guardarPelicula/")
    public String guardarPelicula(Model model, Pelicula pelicula, RedirectAttributes attributes) {
        peliculasService.guardarPelicula(pelicula);
        model.addAttribute("titulo", "Nueva pelicula");
        attributes.addFlashAttribute("msg", "Los datos de la pelicula fueron guardados!");
        return "redirect:/peliculas/listado";
    }

    @GetMapping("/editarPelicula/{id}")
    public String editarPelicula(Model model, @PathVariable("id") Integer id) {
        Pelicula pelicula = peliculasService.buscarPeliculaPorId(id);
        model.addAttribute("titulo", "Editar pelicula");
        model.addAttribute("pelicula", pelicula);
        return "peliculas/formPelicula";
    }

    @GetMapping("/borrarPelicula/{id}")
    public String eliminarPelicula(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        peliculasService.eliminarPelicula(id);
        attributes.addFlashAttribute("msg", "Los datos de la pelicula fueron borrados!");
        return "redirect:/peliculas/listado";
    }
}
