
package REST;

import com.google.gson.Gson;
import controlador.LoginControlador;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.Usuario;


@Path("log")
public class loginREST extends Application{
    
    @Path("in")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response in(@FormParam("usuario") @DefaultValue("0") String nU, @FormParam("contrasenia") @DefaultValue("0") String c){
        String out = "";
        try {
            Usuario u = new Usuario();
            LoginControlador cL = new LoginControlador();
            u = cL.login(nU, c);
            
            boolean status = false;
            if(u == null){
                status = false;
            }
            else{
                status = true;
            }
            
            if(status){
                String KEY = "LibrosUTL";
                long tiempo = System.currentTimeMillis();
                String jwt = Jwts.builder()
                                .signWith(SignatureAlgorithm.HS256, KEY)
                                .setSubject(u.getUsuario())
                                .setIssuedAt(new Date(tiempo))
                                .setExpiration(new Date(tiempo=9000000))
                                .claim("usuario", u.getUsuario())
                                .compact();
                JsonObject json = Json.createObjectBuilder()
                        .add("JWT", jwt).build();
                Gson objGS = new Gson();
                out = objGS.toJson(json);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            out = "{\"error\":\"Hubo un fallo en el acceso, verifica la información.\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("registrar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(@QueryParam("u") String u){
       String out = "";
       try{
           Gson objGS = new Gson();
           Usuario usuario = objGS.fromJson(u, Usuario.class);
           LoginControlador objCT = new LoginControlador();
           if(objCT.insert(usuario) != true){
               out = "{\"error\":\"Este nombre de usuario ya existe, intenta nuevamente\"}";
           }else{
               out = "{\"result\":\"Usuario registrado correctamente\"}";
           }
       }catch(Exception ex){
           ex.printStackTrace();
           out = "{\"error\":\"Este nombre de usuario ya existe, intenta nuevamente\"}";
       }
       return Response.status(Response.Status.OK).entity(out).build();
    }
}
