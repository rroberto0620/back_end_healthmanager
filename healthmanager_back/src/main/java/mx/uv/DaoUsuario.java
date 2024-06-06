package mx.uv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario implements IDaoUsuario{
    private static Conexion con = new Conexion();
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;

    @Override
    public void add(Usuario usuario) throws SQLException {
        connection = con.obtenerConexion();
        String consulta = "INSERT INTO Usuario(correo, contrasena, esMedico) VALUES(?,?,?)";
        ps = connection.prepareStatement(consulta);
        ps.setString(1, usuario.getCorreo());
        ps.setString(2, usuario.getContraseña());
        ps.setBoolean(3, usuario.esMedico());
        ps.execute();
        connection.close();
    }

    @Override
    public void update(int id, Usuario usuarioNu) throws SQLException {
        connection = con.obtenerConexion();
        String consulta = "Update Usuario "
            + "set correo = ?, contrasena = ?, esMedico = ? "
            + "where idUsuario = ? ;";
        ps = connection.prepareStatement(consulta);
        ps.setString(1, usuarioNu.getCorreo());
        ps.setString(2, usuarioNu.getContraseña());
        ps.setBoolean(3, usuarioNu.esMedico());
        ps.setInt(4, id);
        ps.execute();
        connection.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        connection = con.obtenerConexion();
        String consulta = "Delete FROM Usuario where idUsuario = ?;";
        ps = connection.prepareStatement(consulta);
        ps.setInt(1, id);
        ps.execute();
        connection.close();
    }

    @Override
    public List<Usuario> getData() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();

        String consulta = "SELECT * FROM Usuario";
        connection = con.obtenerConexion();
        st = connection.createStatement();
        rs = st.executeQuery(consulta);

        while(rs.next()){

            //Usuario (idUsuario, correo, contraseña, esMedico)
            int id = rs.getInt("idUsuario");
            String correo = rs.getString("correo");
            String contraseña = rs.getString("contrasena");
            Boolean esMedico = rs.getBoolean("esMedico");

            usuarios.add(new Usuario(id, correo, contraseña, esMedico));
        }
        connection.close();
        return usuarios;
    }

    @Override
    public List<Usuario> getDataWhere(String condicion) throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();

        String consulta = "SELECT * FROM Usuario WHERE " + condicion;
        connection = con.obtenerConexion();
        st = connection.createStatement();
        rs = st.executeQuery(consulta);
        while(rs.next()){

            //Usuario (idUsuario, correo, contraseña, esMedico)
            int id = rs.getInt("idUsuario");
            String correo = rs.getString("correo");
            String contraseña = rs.getString("contrasena");
            Boolean esMedico = rs.getBoolean("esMedico");

            usuarios.add(new Usuario(id, correo, contraseña, esMedico));
        }
        connection.close();
        return usuarios;
    }

    public static boolean estaRegistrado(String correo, String contraseña) throws SQLException{
        boolean respuesta = false;
        Connection conn = con.obtenerConexion();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT correo, contrasena, esMedico FROM Usuario WHERE correo='" + correo + "' AND contrasena='" + contraseña + "';");        
            //ResultSet rs = st.executeQuery("SELECT correo FROM usuario WHERE correo='" + correo + "';");
            if (rs.next()) {
                respuesta = true;
            }
        } catch (Exception ex) {
            System.out.println("Error al iniciar sesion: " + ex.toString());
        }finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return respuesta;
    }

    public static boolean esMedico(String correo, String contraseña) throws SQLException{
        boolean respuesta = false;
        Connection conn = con.obtenerConexion();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT esMedico FROM Usuario WHERE correo='" + correo + "' AND contrasena='" + contraseña + "'AND esMedico='1';");        
            //ResultSet rs = st.executeQuery("SELECT correo FROM usuario WHERE correo='" + correo + "';");
            if (rs.next()) {
                respuesta = true;
            }
        } catch (Exception ex) {
            System.out.println("Error al iniciar sesion: " + ex.toString());
        }finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return respuesta;
    }
    

    public static List<Receta> dameMiReceta(String nombreUsuario) throws SQLException{
        Connection conn = con.obtenerConexion();
        ArrayList<Receta> recetas = new ArrayList<>();
        try{
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT idRec, nombreMed, firmaMed, contactoMed, pesoPac, edadPac, fecha, presArt, tempPac, contenido FROM Receta WHERE fk_idPac = '" + nombreUsuario + "';");
             while (rs.next()){
                Receta receta = new Receta(rs.getInt("idRec"), rs.getString("nombreMed"), 
                rs.getString("firmaMed"), rs.getString("contactoMed"),rs.getFloat("pesoPac"),
                rs.getInt("edadPac"),rs.getString("fecha"),rs.getString("contenido"),rs.getString("presArt"),rs.getFloat("tempPac"));
                recetas.add(receta);
             }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return recetas;
    }
    
    public static List<Paciente> dameMiPaciente(String nombreUsuario) throws SQLException{
        Connection conn = con.obtenerConexion();
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try{
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT idPac, nombre, edad, peso, contacto, fk_idUsuario FROM Paciente;");
             while (rs.next()){
                Paciente paciente = new Paciente(rs.getInt("idPac"), rs.getString("nombre"), 
                rs.getInt("edad"), rs.getFloat("peso"),rs.getString("contacto"),
                rs.getInt("fk_idUsuario"));
                pacientes.add(paciente);
             }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return pacientes;
    }

    public static String agregarUsuario(Usuario u) throws SQLException {
        PreparedStatement stm = null;
        Connection conn = null;
        String msj = "";

        conn = con.obtenerConexion();
        try {
            String sql = "INSERT INTO Usuario (idUsuario, correo, contrasena, esMedico) values (?,?,?,?)";
            stm = (PreparedStatement) conn.prepareStatement(sql);
            stm.setInt(1, u.getIdUsuario());
            stm.setString(2, u.getCorreo());
            stm.setString(3, u.getContraseña());
            stm.setBoolean(4, u.esMedico());
            if (stm.executeUpdate() > 0)
                msj = "Usuario agregado";
            else
                msj = "usuario no agregado";

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                stm = null;
            }
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return msj;
    }
}
