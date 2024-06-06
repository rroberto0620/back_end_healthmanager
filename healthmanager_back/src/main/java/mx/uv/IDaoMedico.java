package mx.uv;

import java.sql.SQLException;
import java.util.List;

public interface IDaoMedico {
    public void add(Medico medico) throws SQLException;
    public void update(int id, Medico medico) throws SQLException;
    public void delete(int id) throws SQLException;
    public List<Medico> getData() throws SQLException;
    public List<Medico> getDataWhere(String condicion) throws SQLException;
}
