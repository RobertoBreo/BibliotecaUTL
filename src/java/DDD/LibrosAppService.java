
package DDD;

import CQRS.LibrosComandosCQRS;
import DAO.DAOLibros;
import ViewModel.LibrosViewModel;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import modelo.Libro;

public class LibrosAppService {
    
    public List<Libro> consultarLibros(Libro libro){
        List<Libro> lista = new ArrayList<Libro>();
        try {
            DAOLibros dao = new DAOLibros();
            lista = dao.getLibro(libro);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public List<LibrosViewModel> consultarLibrosPublic(Libro libro){
        List<Libro> listaLibro = new ArrayList<Libro>();
        List<LibrosViewModel> lista = new ArrayList<>();
        DAOLibros dao = new DAOLibros();
        try {
            listaLibro = dao.getLibro(libro);
            for (int i = 0; i < listaLibro.size(); i++) {
                lista.add(new LibrosViewModel(listaLibro.get(i).getIdLibro(), listaLibro.get(i).getNombreLibro(), listaLibro.get(i).getDescripcion(), 
                        listaLibro.get(i).getTema(), listaLibro.get(i).getEstatus()));
            }
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
            LibrosComandosCQRS comando = new LibrosComandosCQRS();
            if(comando.registrarLibro(libro) == true){
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
            LibrosComandosCQRS comando = new LibrosComandosCQRS();
            if(comando.registrarLibroPublic(libro) == true){
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
            LibrosComandosCQRS comando = new LibrosComandosCQRS();
            if(comando.modificarLibro(libro) == true){
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
            LibrosComandosCQRS comando = new LibrosComandosCQRS();
            if(comando.eliminarLibro(libro) == true){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<InetAddress> mostrarIPs(){
        List<InetAddress> lista = new ArrayList<InetAddress>();
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            
            while(interfaces.hasMoreElements()){
                
                NetworkInterface interfaz = interfaces.nextElement();
                Enumeration<InetAddress> direcciones = interfaz.getInetAddresses();
                
                while(direcciones.hasMoreElements()){
                    
                    InetAddress direccion = direcciones.nextElement();
                    if(direccion instanceof InetAddress
                            && !direccion.isLoopbackAddress()){
                        //lista.add(direccion);
                        System.out.println(direccion);
                        //System.out.println(lista);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error -> " + e.getMessage());
        }
        return lista;
    }
}
