
package modelo;

/**
 *
 * @author rober
 */
public class Usuario {
    private String usuario;
    private String contrasenia;
    private int idUsuario;

    public Usuario() {
    }

    public Usuario(String usuario, String contrasenia, int idUsuario) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", contrasenia=" + contrasenia + ", idUsuario=" + idUsuario + '}';
    }
    
}
