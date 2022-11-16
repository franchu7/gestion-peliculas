package es.uah.peliculasActores.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "actores", schema = "peliculasactoresdb", catalog = "")
public class Actor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idActor")
    private Integer idActor;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;
    @Basic
    @Column(name = "pais")
    private String pais;

    @ManyToMany
    @JoinTable(name = "peliculas_has_actores", joinColumns = {
            @JoinColumn(name = "Actores_idActor", referencedColumnName = "idActor")}, inverseJoinColumns = {
            @JoinColumn(name = "Peliculas_idPelicula", referencedColumnName = "idPelicula")})

    @JsonIgnoreProperties("actores")
    private List<Pelicula> peliculas;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(idActor, actor.idActor) && Objects.equals(nombre, actor.nombre) && Objects.equals(fechaNacimiento, actor.fechaNacimiento) && Objects.equals(pais, actor.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActor);
    }
}
