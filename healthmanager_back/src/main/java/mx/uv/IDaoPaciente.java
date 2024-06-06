package mx.uv;

import java.sql.SQLException;
import java.util.List;

public interface IDaoPaciente {
    public void add(Paciente paciente) throws SQLException;
    public void update(int id, Paciente paciente) throws SQLException;
    public void delete(int id) throws SQLException;
    public List<Paciente> getData() throws SQLException;
    public List<Paciente> getDataWhere(String condicion) throws SQLException;
}