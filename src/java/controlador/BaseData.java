/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rober
 */
public class BaseData {
    Connection conexion;
    
    public Connection openServer() throws Exception{
        //Establecer el driver con el que se va a trabajar
        String driver = "com.mysql.jdbc.Driver";
        // Establecer ruta de conexion
        String url = "jdbc:mysql://10.16.12.187:3306/login?autoReconnect=true&useSSL=false&serverTimezone=UTC";
        //Establecer los valores para los permisos de acceso
        String user = "newuser";
        String password = "1111";
        
        //Damos de alta el uso del Driver
        Class.forName(driver);
        
        // Abrimos la conexion
        conexion = DriverManager.getConnection(url, user, password);
        // Retornamos la conexion que se ha creado y abierto
        return conexion;
    }
    
    public Connection open() throws Exception{
        //Establecer el driver con el que se va a trabajar
        String driver = "com.mysql.jdbc.Driver";
        // Establecer ruta de conexion
        String url = "jdbc:mysql://localhost:3306/login?serverTimezone=UTC ";
        //Establecer los valores para los permisos de acceso
        String user = "root";
        String password = "Wilson123456";
        
        //Damos de alta el uso del Driver
        Class.forName(driver);
        
        // Abrimos la conexion
        conexion = DriverManager.getConnection(url, user, password);
        // Retornamos la conexion que se ha creado y abierto
        return conexion;
    }
    /**
     * Este metodo es para cerrar una conexion a BD de MySQL que este abierta
     */
    public void close()
    {
        try {
        if(conexion != null)
                conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
