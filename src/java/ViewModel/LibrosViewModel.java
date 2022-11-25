
package ViewModel;

public class LibrosViewModel {
    private int libro_id;
    private String libro_nombre;
    private String libro_descripcion;
    private String libro_tema;
    private int libro_estatus;

    public LibrosViewModel() {
    }

    public LibrosViewModel(String libro_nombre, String libro_descripcion, String libro_tema, int libro_estatus) {
        this.libro_nombre = libro_nombre;
        this.libro_descripcion = libro_descripcion;
        this.libro_tema = libro_tema;
        this.libro_estatus = libro_estatus;
    }
    
    public LibrosViewModel(int libro_id, String libro_nombre, String libro_descripcion, String libro_tema, int libro_estatus) {
        this.libro_id = libro_id;
        this.libro_nombre = libro_nombre;
        this.libro_descripcion = libro_descripcion;
        this.libro_tema = libro_tema;
        this.libro_estatus = libro_estatus;
    }

    public int getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(int libro_id) {
        this.libro_id = libro_id;
    }

    public String getLibro_nombre() {
        return libro_nombre;
    }

    public void setLibro_nombre(String libro_nombre) {
        this.libro_nombre = libro_nombre;
    }

    public String getLibro_descripcion() {
        return libro_descripcion;
    }

    public void setLibro_descripcion(String libro_descripcion) {
        this.libro_descripcion = libro_descripcion;
    }

    public String getLibro_tema() {
        return libro_tema;
    }

    public void setLibro_tema(String libro_tema) {
        this.libro_tema = libro_tema;
    }

    public int getLibro_estatus() {
        return libro_estatus;
    }

    public void setLibro_estatus(int libro_estatus) {
        this.libro_estatus = libro_estatus;
    }

    @Override
    public String toString() {
        return "LibrosViewModel{" + "libro_id=" + libro_id + ", libro_nombre=" + libro_nombre + ", libro_descripcion=" + libro_descripcion + ", libro_tema=" + libro_tema + ", libro_estatus=" + libro_estatus + '}';
    }

    
}
