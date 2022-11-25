
package DAO;

import ViewModel.LibrosViewModel;
import controlador.BaseData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Libro;

public class DAOLibros extends BaseData{
    
    
    public List<Libro> getLibro(Libro l) throws Exception {
        List<Libro> libros = new ArrayList<Libro>();
        try {
            PreparedStatement pstmt = this.open().prepareStatement("SELECT * FROM libros WHERE estatus="+l.getEstatus()+";");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            Libro libro = new Libro();
            libro.setIdLibro(rs.getInt("idLibro"));
            libro.setNombreLibro(rs.getString("nombre"));
            libro.setDescripcion(rs.getString("descripcion"));
            libro.setTema(rs.getString("tema"));
            
            libros.add(libro);
            }
            
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            this.close();
        }
        return libros;
    }

    
    public boolean insertar(Libro libro) throws Exception {
        try {
            PreparedStatement pstmt = this.open().prepareStatement("INSERT INTO libros (nombre, descripcion, tema, estatus) VALUES (?, ?, ?, 1)");
            pstmt.setString(1, libro.getNombreLibro());
            pstmt.setString(2, libro.getDescripcion());
            pstmt.setString(3, libro.getTema());
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
    
    
    public boolean insertarLibro(LibrosViewModel libro) throws Exception {
        try {
            PreparedStatement pstmt = this.open().prepareStatement("INSERT INTO libros (nombre, descripcion, tema, estatus) VALUES (?, ?, ?, 1)");
            pstmt.setString(1, libro.getLibro_nombre());
            pstmt.setString(2, libro.getLibro_descripcion());
            pstmt.setString(3, libro.getLibro_tema());
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

    
    public boolean modificar(Libro libro) throws Exception {
        try {
            PreparedStatement pstmt = this.open().prepareStatement("UPDATE libros SET nombre='"+libro.getNombreLibro()+"', "
                                                                + "descripcion='"+libro.getDescripcion()+"', "
                                                                + "tema='"+libro.getTema()+"' WHERE idLibro="+libro.getIdLibro()+";");
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

    
    public boolean eliminar(Libro libro) throws Exception {
        try {
            PreparedStatement pstmt = this.open().prepareStatement("UPDATE libros SET estatus = 0 WHERE idLibro ="+libro.getIdLibro()+";");
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

    
    public List<LibrosViewModel> getLibroPublic(LibrosViewModel l) throws Exception {
        List<LibrosViewModel> libros = new ArrayList<>();
        try {
            PreparedStatement pstmt = this.open().prepareStatement("SELECT * FROM libros WHERE estatus="+l.getLibro_estatus()+";");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            LibrosViewModel libro = new LibrosViewModel();
            libro.setLibro_id(rs.getInt("idLibro"));
            libro.setLibro_nombre(rs.getString("nombre"));
            libro.setLibro_descripcion(rs.getString("descripcion"));
            libro.setLibro_tema(rs.getString("tema"));
            
            libros.add(libro);
            }
            
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally{
            this.close();
        }
        return libros;
    }

    
    
}
