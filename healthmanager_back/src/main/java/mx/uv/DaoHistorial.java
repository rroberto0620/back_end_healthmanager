package mx.uv;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoHistorial implements IDaoHistorial{

    private final Conexion con;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;

    public DaoHistorial(){
        con=new Conexion();
    }

    @Override
    public void add(Historial historial) throws SQLException {
        connection = con.obtenerConexion();
        String consulta = "INSERT INTO Historial (fecha, fk_idPac, fk_idRec) VALUES(?,?,?)";
        ps = connection.prepareStatement(consulta);
        ps.setDate(1, historial.getFecha());
        ps.setInt(2, historial.getIdPac());
        ps.setInt(3, historial.getIdRec());
        ps.execute();
        connection.close();
    }

    @Override
    public void update(int id, Historial historial) throws SQLException {
        connection = con.obtenerConexion();
        String consulta = "Update Historial "
            + "set fecha = ?, fk_idPac = ?, fk_idRec = ? "
            + "where idHistorial = ? ;";
            ps = connection.prepareStatement(consulta);
            ps.setDate(1, historial.getFecha());
            ps.setInt(2, historial.getIdPac());
            ps.setInt(3, historial.getIdRec());
            ps.setInt(4, id);
            ps.execute();
            connection.close();
        
    }

    @Override
    public void delete(int id) throws SQLException {
        connection = con.obtenerConexion();
        String consulta = "Delete FROM Historial where idHistorial = ?;";
        ps = connection.prepareStatement(consulta);
        ps.setInt(1, id);
        ps.execute();
        connection.close();
    }

    @Override
    public List<Historial> getData() throws SQLException {
        List<Historial> historiales = new ArrayList<>();

        String consulta = "SELECT * FROM Historial";
        connection = con.obtenerConexion();
        st = connection.createStatement();
        rs = st.executeQuery(consulta);

        while(rs.next()){
            int id = rs.getInt("idHistorial");
            Date fecha = rs.getDate("fecha");
            int idPac = rs.getInt("fk_idPac");
            int idRec = rs.getInt("fk_idRec");

            historiales.add(new Historial(id, fecha, idRec, idPac));
        }
        connection.close();
        return historiales;
    }

    @Override
    public List<Historial> getDataWhere(String condicion) throws SQLException {
        List<Historial> historiales = new ArrayList<>();

        String consulta = "SELECT * FROM Historial where " + condicion;
        connection = con.obtenerConexion();
        st = connection.createStatement();
        rs = st.executeQuery(consulta);

        while(rs.next()){
            int id = rs.getInt("idHistorial");
            Date fecha = rs.getDate("fecha");
            int idPac = rs.getInt("fk_idPac");
            int idRec = rs.getInt("fk_idRec");

            historiales.add(new Historial(id, fecha, idRec, idPac));
        }
        connection.close();
        return historiales;
    }

    
    
}
