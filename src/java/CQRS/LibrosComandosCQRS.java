
package CQRS;

import DAO.DAOLibros;
import ViewModel.LibrosViewModel;
import modelo.Libro;

public class LibrosComandosCQRS {
    
    public boolean registrarLibro(Libro l) throws Exception {
        if(l.getNombreLibro() == ""){
            return false;
        }
        if(l.getDescripcion() == ""){
            return false;
        }
        if(l.getTema( )== ""){
            return false;
        }
        try {
            DAOLibros dao = new DAOLibros();
            if(dao.insertar(l) == true){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean registrarLibroPublic(LibrosViewModel l) throws Exception {
        if(l.getLibro_nombre()== ""){
            return false;
        }
        if(l.getLibro_descripcion()== ""){
            return false;
        }
        if(l.getLibro_tema()== ""){
            return false;
        }
        try {
            DAOLibros dao = new DAOLibros();
            if(dao.insertarLibro(l) == true){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean modificarLibro(Libro l) throws Exception {
        if(l.getNombreLibro() == ""){
            return false;
        }
        if(l.getDescripcion() == ""){
            return false;
        }
        if(l.getTema() == ""){
            return false;
        }
        try {
            DAOLibros dao = new DAOLibros();
            if(dao.modificar(l) == true){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean eliminarLibro(Libro l) throws Exception {
        if(l.getIdLibro() <= 0){
            return false;
        }
        try {
            DAOLibros dao = new DAOLibros();
            if(dao.eliminar(l) == true){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
