
package controlador;

import DAO.DAOUsuario;
import DDD.UsuariosAppService;
import modelo.Usuario;

public class LoginControlador {
    
    public Usuario login(String nombreUsuario, String contrasenia) throws Exception {
        
        Usuario usuario = new Usuario();
        usuario.setUsuario(nombreUsuario);
        usuario.setContrasenia(contrasenia);
        
        try {
            UsuariosAppService ddd = new UsuariosAppService();
            ddd.login(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }
    
    public boolean insert(Usuario u) throws Exception {
        try {
            DAOUsuario dao = new DAOUsuario();
            if(dao.insertar(u) == true){
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
