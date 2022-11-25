
package CQRS;

import DAO.DAOUsuario;
import modelo.Usuario;

/**
 *
 * @author rober
 */
public class UsuariosComandosCQRS {
    
    public boolean insertarUsuario(Usuario usuario) throws Exception {
        try {
            DAOUsuario dao = new DAOUsuario();
            if(dao.insertar(usuario) == true){
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
