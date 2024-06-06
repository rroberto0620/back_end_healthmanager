package mx.uv;

import java.sql.SQLException;
import java.util.List;

public interface IDaoUsuario {
    public void add(Usuario usuario) throws SQLException;
    public void update(int id, Usuario usuarioNu) throws SQLException;
    public void delete(int id) throws SQLException;
    public List<Usuario> getData() throws SQLException;
    public List<Usuario> getDataWhere(String condicion) throws SQLException;
}
