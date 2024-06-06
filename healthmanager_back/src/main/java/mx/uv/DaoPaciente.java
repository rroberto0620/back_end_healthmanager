package mx.uv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoPaciente implements IDaoPaciente{

    private static Conexion con = new Conexion();
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;

    public DaoPaciente(){
        //con=new Conexion();
    }

    @Override
    public void add(Paciente paciente) throws SQLException {
        connection = con.obtenerConexion();
        String consulta = "INSERT INTO Paciente(nombre, edad, peso, contacto,fk_idUsuario) VALUES(?,?,?,?,?)";
        ps = connection.prepareStatement(consulta);
        ps.setString(1, paciente.getNombre());
        ps.setInt(2, paciente.getEdad());
        ps.setFloat(3, paciente.getPeso());
        ps.setString(4, paciente.getContacto());
        ps.setInt(5, paciente.getIdUsuario());
        ps.execute();
        connection.close();
    }

    @Override
    public void update(int id, Paciente paciente) throws SQLException {
        connection = con.obtenerConexion();
        String consulta = "Update Paciente "
            + "set nombre = ?, edad = ?, peso = ?, contacto = ?,  fk_idUsuario = ? "
            + "where idPac = ? ;";
            ps = connection.prepareStatement(consulta);
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getEdad());
            ps.setFloat(3, paciente.getPeso());
            ps.setString(4, paciente.getContacto());
            ps.setInt(5, paciente.getIdUsuario());
            ps.setInt(6, id);
            ps.execute();
        ps = connection.prepareStatement(consulta);
    }

    @Override
    public void delete(int id) throws SQLException {
        connection = con.obtenerConexion();
        String consulta = "Delete FROM Paciente where idPac = ?;";
        ps = connection.prepareStatement(consulta);
        ps.setInt(1, id);
        ps.execute();
        connection.close();
    }

    @Override
    public List<Paciente> getData() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();

        String consulta = "SELECT * FROM Paciente";
        connection = con.obtenerConexion();
        st = connection.createStatement();
        rs = st.executeQuery(consulta);

        while(rs.next()){

            int id = rs.getInt("idPac");
            String nombre = rs.getString("nombre");
            int edad = rs.getInt("edad");
            float peso = rs.getFloat("peso");
            String contacto = rs.getString("contacto");
            int idUsuario = rs.getInt("fk_idUsuario");

            pacientes.add(new Paciente(id, nombre, edad, peso, contacto, idUsuario));
        }
        connection.close();
        return pacientes;
    }

    @Override
    public List<Paciente> getDataWhere(String condicion) throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();

        String consulta = "SELECT * FROM Paciente WHERE " + condicion;
        connection = con.obtenerConexion();
        st = connection.createStatement();
        rs = st.executeQuery(consulta);

        while(rs.next()){

            int id = rs.getInt("idPac");
            String nombre = rs.getString("nombre");
            int edad = rs.getInt("edad");
            float peso = rs.getFloat("peso");
            String contacto = rs.getString("contacto");
            int idUsuario = rs.getInt("fk_idUsuario");

            pacientes.add(new Paciente(id, nombre, edad, peso, contacto, idUsuario));
        }
        connection.close();
        return pacientes;
    }

    public static Paciente datosPaciente(String correoUsuario) throws SQLException {
        Connection conn = con.obtenerConexion();
        Paciente paciente = null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre , edad , peso, contacto, idPac FROM Paciente INNER JOIN Usuario ON Paciente.idPac = Usuario.idUsuario WHERE correo='" + correoUsuario + "'");
            while (rs.next()) {
                paciente = new Paciente(rs.getString("nombre"), rs.getInt("edad"),rs.getFloat("peso"),rs.getString("contacto"),rs.getInt("idPac"));
            }
            System.out.println(paciente);
        } catch (Exception ex) {
            System.out.println("Error al obtener datos del usuario: " + ex.toString());
        }finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return paciente;
    }

    public static Boolean eliminarPaciente(String idPac) throws SQLException {
        Connection conn = con.obtenerConexion();
        boolean eliminado = false;
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Paciente WHERE idPac='" + idPac + "'");
            ps.executeUpdate();
            eliminado = true;
        }catch (Exception ex) {
            System.out.println("Error al eliminar paciente: " + ex.toString());
        }finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return eliminado;
    }
    
    public static String agregarPaciente(Paciente p) throws SQLException {
        PreparedStatement stm = null;
        Connection conn = null;
        String msj = "";

        conn = con.obtenerConexion();
        try {
            String sql = "INSERT INTO Paciente (idPac, nombre, edad, peso, contacto, fk_idUsuario) values (?,?,?,?,?,?)";
            stm = (PreparedStatement) conn.prepareStatement(sql);
            stm.setInt(1, p.getIdPac());
            stm.setString(2, p.getNombre());
            stm.setInt(3, p.getEdad());
            stm.setFloat(4, p.getPeso());
            stm.setString(5,p.getContacto());
            stm.setInt(6,p.getIdUsuario());
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
