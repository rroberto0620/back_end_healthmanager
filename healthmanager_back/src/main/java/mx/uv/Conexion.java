package mx.uv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection conexion;
    String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://root:ECGtugnerOnWGDCdGXSlqeNQSUGEJfhk@monorail.proxy.rlwy.net:15340/railway";
    private final String USUARIO="root";
    private final String CONTRASENA="ECGtugnerOnWGDCdGXSlqeNQSUGEJfhk";

    public Connection obtenerConexion() throws SQLException{
        conecta();
        return conexion;
    }
    
    private void conecta() throws SQLException{
    try {
      Class.forName(driver);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
      conexion=DriverManager.getConnection(url,USUARIO,CONTRASENA);
    }
    
    public void cerrarConexion(){
        if(conexion!=null){
            try {
                if(!conexion.isClosed()){
                    conexion.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
