package mx.uv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoMedico implements IDaoMedico{

    private static Conexion con = new Conexion();
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;

    public DaoMedico(){
        con=new Conexion();
    }

    @Override
    public void add(Medico medico) throws SQLException {
        connection = con.obtenerConexion();
        String consulta = "INSERT INTO Medico (nombreMed, cedProf, contacto, fk_idUsuario) VALUES(?,?,?,?)";

        ps = connection.prepareStatement(consulta);
        ps.setString(1, medico.getNombreMed());
        ps.setString(2, medico.getCedProf());
        ps.setString(3, medico.getContacto());
        ps.setInt(4, medico.getIdUsuario());
        ps.execute();
        connection.close();
    }

    @Override
    public void update(int id, Medico medico) throws SQLException {
        connection = con.obtenerConexion();
        String consulta = "Update Medico "
            + "set nombreMed = ?, cedProf = ?, contacto = ?,  fk_idUsuario = ? "
            + "where idMed = ? ;";
            ps = connection.prepareStatement(consulta);
            ps.setString(1, medico.getNombreMed());
            ps.setString(2, medico.getCedProf());
            ps.setString(3, medico.getContacto());
            ps.setInt(4, medico.getIdUsuario());
            ps.setInt(5, id);
            ps.execute();
            connection.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        connection = con.obtenerConexion();
        String consulta = "Delete FROM Medico where idMed = ?;";
        ps = connection.prepareStatement(consulta);
        ps.setInt(1, id);
        ps.execute();
        connection.close();
    }

    @Override
    public List<Medico> getData() throws SQLException {
        List<Medico> medicos = new ArrayList<>();

        String consulta = "SELECT * FROM Medico";
        connection = con.obtenerConexion();
        st = connection.createStatement();
        rs = st.executeQuery(consulta);

        while(rs.next()){

            int id = rs.getInt("idMed");
            String nombre = rs.getString("nombreMed");
            String cedProf = rs.getString("cedProf");
            String contacto = rs.getString("contacto");
            int idUsuario = rs.getInt("fk_idUsuario");

            //Verificación de obtención de datos
            System.out.println(id + " " + nombre + " " + cedProf + " " + contacto + idUsuario);

            medicos.add(new Medico(id, nombre, cedProf, contacto, idUsuario));
        }
        connection.close();
        return medicos;
    }

    @Override
    public List<Medico> getDataWhere(String condicion) throws SQLException {
        List<Medico> medicos = new ArrayList<>();

        String consulta = "SELECT * FROM Medico WHERE " + condicion;
        connection = con.obtenerConexion();
        st = connection.createStatement();
        rs = st.executeQuery(consulta);

        while(rs.next()){

            int id = rs.getInt("idMed");
            String nombre = rs.getString("nombreMed");
            String cedProf = rs.getString("cedProf");
            String contacto = rs.getString("contacto");
            int idUsuario = rs.getInt("fk_idUsuario");

            //Verificación de obtención de datos
            System.out.println(id + " " + nombre + " " + cedProf + " " + contacto + idUsuario);

            medicos.add(new Medico(id, nombre, cedProf, contacto, idUsuario));
        }
        connection.close();
        return medicos;
    }

    public static Medico datosMedico(String correoUsuario) throws SQLException {
        Connection conn = con.obtenerConexion();
        Medico medico = null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT idMed , nombreMed , cedProf, contacto, fk_idUsuario FROM Medico INNER JOIN Usuario ON Medico.fk_idUsuario = Usuario.idUsuario WHERE correo='" + correoUsuario + "'");
            while (rs.next()) {
                medico = new Medico(rs.getInt("idMed"), rs.getString("nombreMed"),rs.getString("cedProf"),rs.getString("contacto"),rs.getInt("fk_idUsuario"));
            }
            System.out.println(medico);
        } catch (Exception ex) {
            System.out.println("Error al obtener datos del usuario: " + ex.toString());
        }finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return medico;
    }
    
}
