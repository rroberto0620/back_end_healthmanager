package mx.uv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoReceta implements IDaoReceta{
    private static Conexion con = new Conexion();
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;

    public DaoReceta(){
        con=new Conexion();
    }

    @Override
    public void add(Receta receta) throws SQLException {
        connection = con.obtenerConexion();
        String consulta = "Receta (nombreMed, firmaMed, contactoMed, pesoPac, edadPac, fecha, presArt, tempPac, fk_idMed, fk_idPac) VALUES(?,?,?,?,?,?,?,?,?,?)";
        ps = connection.prepareStatement(consulta);
        //Receta(String nombreMed, Blob firmaMed, String contactoMed, float pesoPac, int edadPac, Date fecha,float presArt, float tempPac, Paciente paciente, Medico medico)
        ps.setString(1, receta.getNombreMed());
        ps.setString(2, receta.getFirmaMed());
        ps.setString(3, receta.getContactoMed());
        ps.setFloat(4, receta.getPesoPac());
        ps.setInt(5, receta.getEdadPac());
        ps.setString(6, receta.getFecha());
        ps.setString(7, receta.getPresArt());
        ps.setFloat(8, receta.getTempPac());
        ps.setInt(9, receta.getIdPaciente());
        ps.setInt(10, receta.getIdMedico());

        ps.execute();
        connection.close();
    }

    @Override
    public void update(int id, Receta receta) throws SQLException {
        connection = con.obtenerConexion();
        String consulta = "UPDATE Receta " 
        + "set nombreMed = ?, firmaMed = ?, "
        + "contactoMed = ?, pesoPac = ?, edadPac = ?, fecha = ?, presArt = ?, " 
        + "tempPac = ?, fk_idMed = ?, fk_idPac = ?"
        + " where idRec = ? ;";
        ps = connection.prepareStatement(consulta);
        //Receta(String nombreMed, Blob firmaMed, String contactoMed, float pesoPac, int edadPac, Date fecha,float presArt, float tempPac, Paciente paciente, Medico medico)
        ps.setString(1, receta.getNombreMed());
        ps.setString(2, receta.getFirmaMed());
        ps.setString(3, receta.getContactoMed());
        ps.setFloat(4, receta.getPesoPac());
        ps.setInt(5, receta.getEdadPac());
        ps.setString(6, receta.getFecha());
        ps.setString(7, receta.getPresArt());
        ps.setFloat(8, receta.getTempPac());
        ps.setInt(9, receta.getIdPaciente());
        ps.setInt(10, receta.getIdMedico());
        ps.setInt(11, id);

        ps.execute();
        connection.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        connection = con.obtenerConexion();
        String consulta = "Delete FROM Receta where idRec = ?;";
        ps = connection.prepareStatement(consulta);
        ps.setInt(1, id);
        ps.execute();
        connection.close();
    }

    @Override
    public List<Receta> getData() throws SQLException {
        List<Receta> recetas = new ArrayList<>();

        String consulta = "SELECT * FROM Receta";
        connection = con.obtenerConexion();
        st = connection.createStatement();
        rs = st.executeQuery(consulta);

        while(rs.next()){

            int idRec = rs.getInt("idRec"); 
            String nombreMed = rs.getString("nombreMed");
            String firmaMed = rs.getString("firmaMed");
            String contactoMed = rs.getString("contactoMed");
            float pesoPac = rs.getFloat("pesoPac");
            int edadPac = rs.getInt("edadPac");
            String fecha = rs.getString("fecha");
            String presArt = rs.getString("presArt");
            float tempPac = rs.getFloat("tempPac");
            String contenido = rs.getString("contenido");
            int idPaciente = rs.getInt("fk_idMed");
            int idMedico = rs.getInt("fk_idPac");

            recetas.add(new Receta(idRec, nombreMed, firmaMed, contactoMed, pesoPac,  edadPac,
            fecha, presArt, tempPac,contenido, idPaciente, idMedico));
        }
        connection.close();
        return recetas;
    }

    @Override
    public List<Receta> getDataWhere(String condicion) throws SQLException {
        List<Receta> recetas = new ArrayList<>();

        String consulta = "SELECT * FROM Receta WHERE " + condicion;
        connection = con.obtenerConexion();
        st = connection.createStatement();
        rs = st.executeQuery(consulta);

        while(rs.next()){

            int idRec = rs.getInt("idRec"); 
            String nombreMed = rs.getString("nombreMed");
            String firmaMed = rs.getString("firmaMed");
            String contactoMed = rs.getString("contactoMed");
            float pesoPac = rs.getFloat("pesoPac");
            int edadPac = rs.getInt("edadPac");
            String fecha = rs.getString("fecha");
            String presArt = rs.getString("presArt");
            float tempPac = rs.getFloat("tempPac");
            String contenido = rs.getString("contenido");
            int idPaciente = rs.getInt("fk_idMed");
            int idMedico = rs.getInt("fk_idPac");

            recetas.add(new Receta(idRec, nombreMed, firmaMed, contactoMed, pesoPac,  edadPac,
            fecha, presArt, tempPac,contenido, idPaciente, idMedico));
        }
        connection.close();
        return recetas;
    }

    public static String realizarReceta(Receta r) throws SQLException{
        Connection conn = con.obtenerConexion();
        PreparedStatement stm = null;
        String msj = "";
        try{
            String sql = "INSERT INTO Receta values (?,?,?,?,?,?,?,?,?,?,?,?)";
            stm = (PreparedStatement) conn.prepareStatement(sql);
            stm.setInt(1, r.getIdRec());
            stm.setString(2, r.getNombreMed());
            stm.setString(3, r.getFirmaMed());
            stm.setString(4, r.getContactoMed());
            stm.setFloat(5, r.getPesoPac());
            stm.setInt(6,r.getEdadPac());
            stm.setString(7, r.getFecha());
            stm.setString(8,r.getPresArt());
            stm.setFloat(9, r.getTempPac());
            stm.setString(10,r.getContenido());
            stm.setInt(11,r.getIdPaciente());
            stm.setInt(12, r.getIdMedico());
            if (stm.executeUpdate() > 0)
                msj = "Receta creada";
            else
                msj = "La receta no se creo";
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return msj;
    }
    
}
