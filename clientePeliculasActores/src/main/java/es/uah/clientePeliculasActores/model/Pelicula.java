package es.uah.clientePeliculasActores.model;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {

    private Integer idPelicula;
    private String titulo;
    private Integer anno;
    private Integer duracion;
    private String pais;
    private String direccion;
    private String genero;
    private String sinopsis;
    private String portada;

    private List<Actor> actores;

    public Pelicula(Integer idPelicula, String titulo, Integer anno, Integer duracion, String pais, String direccion, String genero, String sinopsis, String portada, List<Actor> actores) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.anno = anno;
        this.duracion = duracion;
        this.pais = pais;
        this.direccion = direccion;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.portada = portada;
        this.actores = actores;
    }

    public Pelicula() {
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public List<String> getNombresActores() {
        List<String> nombresActores = new ArrayList<>();
        for(int i = 0; i < this.actores.size(); i++) {
            nombresActores.add(this.actores.get(i).getNombre());
        }
        return nombresActores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public void addActor(Actor actor) {
        if (actor != null) {
            getActores().add(actor);
        }
    }

    public void removeActor(Actor actor) {
        if (actor != null) {
            getActores().remove(actor);
        }
    }
}
