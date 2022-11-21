package es.uah.clientePeliculasActores.model;

import java.sql.Date;
import java.util.List;
;

public class Actor {
    private Integer idActor;
    private String nombre;
    private Date fechaNacimiento;
    private String pais;

    private List<Pelicula> peliculas;

    public Actor(Integer idActor, String nombre, Date fechaNacimiento, String pais) {
        this.idActor = idActor;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
    }

    public Actor() {

    }

    public Integer getIdActor() {
        return idActor;
    }

    public void setIdActor(Integer idActor) {
        this.idActor = idActor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public void addPelicula(Pelicula pelicula) {
        if (pelicula != null) {
            getPeliculas().add(pelicula);
            pelicula.addActor(this);
        }
    }

    public void removePelicula(Pelicula pelicula) {
        if (pelicula != null) {
            pelicula.removeActor(this);
            getPeliculas().remove(pelicula);
        }
    }
}

