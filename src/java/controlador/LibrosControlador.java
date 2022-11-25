
package controlador;

import DDD.LibrosAppService;
import ViewModel.LibrosViewModel;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import modelo.Libro;


public class LibrosControlador {
    
    public List<Libro> getAll(Libro libro) throws Exception {
        
        List<Libro> lista = new ArrayList<Libro>();
        try {
            LibrosAppService ddd = new LibrosAppService();
            lista = ddd.consultarLibros(libro);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public List<LibrosViewModel> getAllPublic(Libro libro) throws Exception {
        
        List<LibrosViewModel> lista = new ArrayList<>();
        try {
            LibrosAppService ddd = new LibrosAppService();
            lista = ddd.consultarLibrosPublic(libro);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public List<InetAddress> getSucursales() throws Exception {
        
        List<InetAddress> lista = new ArrayList<InetAddress>();
        try {
            LibrosAppService ddd = new LibrosAppService();
            lista = ddd.mostrarIPs();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public boolean insert(Libro libro) throws Exception {
        try {
            LibrosAppService ddd = new LibrosAppService();
            if(ddd.insert(libro) == true){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean insertLibro(LibrosViewModel libro) throws Exception {
        try {
            LibrosAppService ddd = new LibrosAppService();
            if(ddd.insertLibro(libro) == true){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean modificar(Libro libro) throws Exception {
        try {
            LibrosAppService ddd = new LibrosAppService();
            if(ddd.modificar(libro) == true){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean modificarLibro(Libro libro) throws Exception {
        try {
            LibrosAppService ddd = new LibrosAppService();
            if(ddd.modificar(libro) == true){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(Libro libro) throws Exception {
        try {
            LibrosAppService ddd = new LibrosAppService();
            if(ddd.eliminar(libro) == true){
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
