
package REST;

import API_SERVICE.LibrosAPIService;
import ViewModel.LibrosViewModel;
import com.google.gson.Gson;
import controlador.LibrosControlador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.Libro;


@Path("libro")
public class librosREST{
    
    @Path("getSucursales")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOtros() throws MalformedURLException, ProtocolException, IOException {
        String out = "";
        try {
        LibrosAPIService api = new LibrosAPIService();
        StringBuilder response = api.librosAPI();
            out = response.toString();
            //System.out.println(api.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            out = "{\"error\":\"Hubo un error al cargar los libros"
                    + " vuelve a intentarlo o llama al administrador del sistema\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getLibro")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLibro(@QueryParam("estatus") int estatus){
        String out = "";
        try {
            List<Libro> libro = new ArrayList<>();
            Libro l = new Libro();
            l.setEstatus(estatus);
            LibrosControlador cL = new LibrosControlador();
            libro = cL.getAll(l);
            Gson objGS = new Gson();
            out = objGS.toJson(libro);
        } catch (Exception e) {
            e.printStackTrace();
            out = "{\"error\":\"Hubo un fallo en el acceso, verifica la información.\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getLibroPublic")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLibroPublic(@QueryParam("estatus") int estatus){
        String out = "";
        try {
            List<LibrosViewModel> libro = new ArrayList<>();
            Libro l = new Libro();
            l.setEstatus(estatus);
            LibrosControlador cL = new LibrosControlador();
            libro = cL.getAllPublic(l);
            Gson objGS = new Gson();
            out = objGS.toJson(libro);
        } catch (Exception e) {
            e.printStackTrace();
            out = "{\"error\":\"Hubo un fallo en el acceso, verifica la información.\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("registrar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(@QueryParam("libro") String libro){
       String out = "";
       try{
           Gson objGS = new Gson();
           Libro l = objGS.fromJson(libro, Libro.class);
           LibrosControlador objCT = new LibrosControlador();
           if(objCT.insert(l) != true){
               out = "{\"error\":\"Este libro ya existe, intenta nuevamente\"}";
           }else{
               out = "{\"result\":\"Libro registrado correctamente\"}";
           }
       }catch(Exception ex){
           ex.printStackTrace();
           out = "{\"error\":\"Este libro ya existe, intenta nuevamente\"}";
       }
       return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("registrarLibro")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarLibro(@QueryParam("libro") String libro) throws MalformedURLException, ProtocolException, IOException{
       String out = "";
       try{
           LibrosAPIService api = new LibrosAPIService();
           if(api.registrarLibro(libro) != true){
               out = "{\"error\":\"Este libro ya existe, intenta nuevamente\"}";
           }else{
               out = "{\"result\":\"Libro registrado correctamente\"}";
           }
       }catch(Exception ex){
           ex.printStackTrace();
           out = "{\"error\":\"Este libro ya existe, intenta nuevamente\"}";
       }
       return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("modificar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificar(@QueryParam("libro") String libro){
       String out = "";
       try{
           Gson objGS = new Gson();
           Libro l = objGS.fromJson(libro, Libro.class);
           LibrosControlador objCT = new LibrosControlador();
           if(objCT.modificar(l) != true){
               out = "{\"error\":\"Hubo un fallo en la modificación, intenta de nuevo\"}";
           }else{
               out = "{\"result\":\"Libro modificado correctamente\"}";
           }
       }catch(Exception ex){
           ex.printStackTrace();
           out = "{\"error\":\"Hubo un fallo en la modificación, intenta de nuevo\"}";
       }
       return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("modificarLibro")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarLibro(@QueryParam("libro") String libro) throws MalformedURLException, ProtocolException, IOException{
       String out = "";
       try{
           LibrosAPIService api = new LibrosAPIService();
           if(api.modificarLibro(libro.toString()) != true){
               out = "{\"error\":\"Hubo un fallo en la modificación, intenta de nuevo\"}";
           }else{
               out = "{\"result\":\"Libro modificado correctamente\"}";
           }
       }catch(Exception ex){
           ex.printStackTrace();
           out = "{\"error\":\"Hubo un fallo en la modificación, intenta de nuevo\"}";
       }
       return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("eliminar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@QueryParam("libro") String libro){
       String out = "";
       try{
           Gson objGS = new Gson();
           Libro l = objGS.fromJson(libro, Libro.class);
           LibrosControlador objCT = new LibrosControlador();
           if(objCT.eliminar(l) != true){
               out = "{\"error\":\"Hubo un fallo en la eliminación, intenta de nuevo\"}";
           }else{
               out = "{\"result\":\"Libro eliminado correctamente\"}";
           }
       }catch(Exception ex){
           ex.printStackTrace();
           out = "{\"error\":\"Hubo un fallo en la eliminación, intenta de nuevo\"}";
       }
       return Response.status(Response.Status.OK).entity(out).build();
    }
}
