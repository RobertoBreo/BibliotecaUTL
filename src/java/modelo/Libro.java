
package modelo;

import java.util.List;

public class Libro {
    private int idLibro;
    private String nombreLibro;
    private String descripcion;
    private String tema;
    private int estatus;

    public Libro() {
    }

    public Libro(int idLibro, String nombreLibro, String descripcion, String tema, int estatus) {
        this.idLibro = idLibro;
        this.nombreLibro = nombreLibro;
        this.descripcion = descripcion;
        this.tema = tema;
        this.estatus = estatus;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", nombreLibro=" + nombreLibro + ", descripcion=" + descripcion + ", tema=" + tema + ", estatus=" + estatus + '}';
    }
    
}
