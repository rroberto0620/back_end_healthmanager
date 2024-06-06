package mx.uv;

public class Usuario {
    private int idUsuario;
    private String correo;
    private String contraseña;
    private boolean esMedico;
    
    public Usuario(int idUsuario, String correo, String contraseña, boolean esMedico) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.esMedico = esMedico;
    }
    public Usuario(String correo, String contraseña, boolean esMedico) {
        this.correo = correo;
        this.contraseña = contraseña;
        this.esMedico = esMedico;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public boolean esMedico() {
        return esMedico;
    }
    public void setEsMedico(boolean esMedico) {
        this.esMedico = esMedico;
    }

    
}
