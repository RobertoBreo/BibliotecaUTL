
package DAO;

import controlador.BaseData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Usuario;

public class DAOUsuario extends BaseData{

    
    public Usuario login(Usuario usuario) throws Exception {
        try {
            PreparedStatement pstmt = this.open().prepareStatement("SELECT * FROM usuarios WHERE usuario=? AND contrasenia=?;");
            pstmt.setString(1, usuario.getUsuario());
            pstmt.setString(2, usuario.getContrasenia());
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setContrasenia(rs.getString("contrasenia"));
            }
            
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            this.close();
        }
        return usuario;
    }
    
    public boolean insertar(Usuario usuario) throws Exception {
        try {
            PreparedStatement pstmt = this.open().prepareStatement("INSERT INTO usuarios (usuario, contrasenia) VALUES (?, ?)");
            pstmt.setString(1, usuario.getUsuario());
            pstmt.setString(2, usuario.getContrasenia());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally{
            this.close();
        }
        return true;
    }
    
}
