package mx.uv;

import java.sql.SQLException;
import java.util.List;

public interface IDaoHistorial {
    public void add(Historial historial) throws SQLException;
    public void update(int id, Historial historial) throws SQLException;
    public void delete(int id) throws SQLException;
    public List<Historial> getData() throws SQLException;
    public List<Historial> getDataWhere(String condicion) throws SQLException;
}
