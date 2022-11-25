
package API_SERVICE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class LibrosAPIService {
    
    public StringBuilder librosAPI() throws ProtocolException, MalformedURLException, IOException{
        
        URL ruta = new URL("http://192.168.138.194:8080/ClienteServidorUTL/api/libro/getLibro?estatus=1");
        //URL ruta = new URL("http://192.168.1.10:8084/ClienteServidorUTL/api/libro/getLibro?estatus=1");
        //URL ruta = new URL("http://192.168.10.194:8080/ClienteServidorUTL/api/libro/getLibro");
        //URL ruta = new URL("http://10.16.9.8:8084/ClienteServidorUTL/api/libro/getLibro?estatus=1");
        //URL ruta = new URL("http://10.16.12.187:8080/ClienteServidorUTL/api/libro/getLibro?estatus=1");
        HttpURLConnection conn = (HttpURLConnection) ruta.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        StringBuilder response = new StringBuilder();
        
        try (
            BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String cadena;
            while ((cadena = input.readLine()) != null) {
                response.append(cadena);
            }
        }
        return response;
    }    
    
    public boolean registrarLibro(String libro) throws ProtocolException, MalformedURLException, IOException{
        String libroP = URLEncoder.encode(libro, "utf-8");
        URL ruta = new URL("http://192.168.138.194:8080/ClienteServidorUTL/api/libro/registrar?libro="+libroP);
        //URL ruta = new URL("http://192.168.1.10:8084/ClienteServidorUTL/api/libro/registrar?libro="+libro);
        HttpURLConnection conn = (HttpURLConnection) ruta.openConnection();
        conn.setRequestMethod("GET");
        //conn.addRequestProperty("libro", libro);
        conn.setDoInput(true);
        
        StringBuilder response = new StringBuilder();
        try(
            BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String cadena;
            while ((cadena = input.readLine()) != null) {
                response.append(cadena);
                System.out.println(response);
            }
        }
        catch (Exception e) {
            e.getMessage();
        }
        return true;  
    }
    
    public boolean modificarLibro(String libro) throws ProtocolException, MalformedURLException, IOException{
        String libroP = URLEncoder.encode(libro, "utf-8");
        URL ruta = new URL("http://192.168.138.194:8080/ClienteServidorUTL/api/libro/modificar?libro="+libroP);
        //URL ruta = new URL("http://192.168.1.10:8084/ClienteServidorUTL/api/libro/modificar?libro="+libro);
        HttpURLConnection conn = (HttpURLConnection) ruta.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        StringBuilder response = new StringBuilder();
        try(
            BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String cadena;
            while ((cadena = input.readLine()) != null) {
                response.append(cadena);
                System.out.println(response);
            }
        }catch (Exception e) {
            e.getMessage();
        }
        return true;  
    }
}
