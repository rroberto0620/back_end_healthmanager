package mx.uv;

import com.google.gson.JsonObject;
import static spark.Spark.*;
import java.util.HashMap;
import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    static Gson gson = new Gson();
    static HashMap<String, Usuario> usuarios = new HashMap<>();
    public static void main( String[] args )
    {
        System.out.println( "HEALTH MANAGER BACK END CORRIENDO..." );

        //CORS
        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
        //CORS

        post("/validacion", (request, response) -> {
            response.type("application/json");
            String payload = request.body();
            String mensaje = "";
            Usuario usuario = gson.fromJson(payload, Usuario.class);
            System.out.println("usuario " + usuario.getCorreo()+ " " + usuario.getContraseña());
            boolean respuesta = DaoUsuario.estaRegistrado(usuario.getCorreo(), usuario.getContraseña());
            boolean respuestaMedico = usuario.esMedico();
            System.out.println(respuesta);
            System.out.println(respuestaMedico);
            if (respuesta == true) {
                System.out.println("Usuario Correcto");
                mensaje = "Usuario Correcto";
                /*if(respuestaMedico == true){
                    mensaje = "Usuario Medico";
                }*/
            } else {
                System.out.println("Usuario incorrecto");
                mensaje = "Usuario incorrecto";
            }
            return mensaje;
        });

        post("/validacionMedico", (request, response) -> {
            response.type("application/json");
            String payload = request.body();
            String mensaje = "";
            Usuario usuario = gson.fromJson(payload, Usuario.class);
            System.out.println("usuario " + usuario.getCorreo() + usuario.getContraseña() + usuario.esMedico());
            boolean respuesta = DaoUsuario.estaRegistrado(usuario.getCorreo(), usuario.getContraseña());
            System.out.println(respuesta);
            if (respuesta == true) {
                System.out.println("Usuario Correcto");
                
                mensaje = "Usuario Correcto";
            } else {
                System.out.println("Usuario incorrecto");
                mensaje = "Usuario incorrecto";
            }
            return mensaje;
        });

        get("/datosUsuario", (request, response) -> {
            String correo = request.queryParams("correo");
            response.type("application/json");
            return gson.toJson(DaoPaciente.datosPaciente(correo));
        });

        get("/MisRecetas", (request, response) -> {
            String nombre = request.queryParams("idUsuario");
            response.type("application/json");
            return gson.toJson(DaoUsuario.dameMiReceta(nombre));
        });

        get("/datosUsuarioMedico", (request, response) -> {
            String correo = request.queryParams("correo");
            response.type("application/json");
            return gson.toJson(DaoMedico.datosMedico(correo));
        });

        post("/realizarReceta", (request, response) -> {
            response.type("application/json");
            String payload = request.body();
            Receta receta = gson.fromJson(payload, Receta.class);
            System.out.println("payload " + payload);
            String respuesta = DaoReceta.realizarReceta(receta);

            return respuesta;
        });

        get("/MisPacientes", (request, response) -> {
            String nombre = request.queryParams("idUsuario");
            response.type("application/json");
            return gson.toJson(DaoUsuario.dameMiPaciente(nombre));
        });

        get("/eliminarPaciente", (request, response) -> {
            response.type("application/json");
            String idPaciente = request.queryParams("idPac");
            System.out.println("Paciente con id: " + idPaciente);
            boolean respuesta = DaoPaciente.eliminarPaciente(idPaciente);
            JsonObject mensaje = new JsonObject();
            mensaje.addProperty("respuesta", respuesta);
            return mensaje;
        });

        post("/AgregarUsuario", (request, response) -> {
            response.type("application/json");
            String payload = request.body();
            Usuario usuario = gson.fromJson(payload, Usuario.class);
            System.out.println("payload " + payload);
            String respuesta = DaoUsuario.agregarUsuario(usuario);

            return respuesta;
        });
    }
}
