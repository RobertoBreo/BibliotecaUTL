/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDD;

import CQRS.UsuariosComandosCQRS;
import DAO.DAOUsuario;
import modelo.Usuario;

/**
 *
 * @author rober
 */
public class UsuariosAppService {
    
    public Usuario login(Usuario usuario) throws Exception {
        try {
            DAOUsuario dao = new DAOUsuario();
            dao.login(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }
    
    public boolean insert(Usuario u) throws Exception {
        try {
            UsuariosComandosCQRS comando = new UsuariosComandosCQRS();
            if(comando.insertarUsuario(u) == true){
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
