package mx.uv;

import java.sql.SQLException;
import java.util.List;

public interface IDaoReceta {
    public void add(Receta receta) throws SQLException;
    public void update(int id, Receta receta) throws SQLException;
    public void delete(int id) throws SQLException;
    public List<Receta> getData() throws SQLException;
    public List<Receta> getDataWhere(String condicion) throws SQLException;
}
