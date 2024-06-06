package mx.uv;

import java.sql.Blob;

public class Medico {
    private int idMed;
    private String nombreMed;
    private String cedProf;
    private String contacto;
    private Blob fotoMed;
    private int idUsuario;

    public Medico(){

    }

    
    
    public Medico(String nombreMed, String cedProf, String contacto, Blob fotoMed, int idUsuario) {
        this.nombreMed = nombreMed;
        this.cedProf = cedProf;
        this.contacto = contacto;
        this.fotoMed = fotoMed;
        this.idUsuario = idUsuario;
    }



    public Medico(String nombreMed, String cedProf, String contacto, int idUsuario) {
        this.nombreMed = nombreMed;
        this.cedProf = cedProf;
        this.contacto = contacto;
        this.idUsuario = idUsuario;
    }



    public Medico(int idMed, String nombreMed, String cedProf, String contacto, int idUsuario) {
        this.idMed = idMed;
        this.nombreMed = nombreMed;
        this.cedProf = cedProf;
        this.contacto = contacto;
        this.idUsuario = idUsuario;
    }



    public Medico(int idMed, String nombreMed, String cedProf, String contacto, Blob fotoMed, int idUsuario) {
        this.idMed = idMed;
        this.nombreMed = nombreMed;
        this.cedProf = cedProf;
        this.contacto = contacto;
        this.fotoMed = fotoMed;
        this.idUsuario = idUsuario;
    }



    public Medico(String nombreMed, String cedProf, String contacto) {
        this.nombreMed = nombreMed;
        this.cedProf = cedProf;
        this.contacto = contacto;
    }


    public Medico(int idMed, String nombreMed, String cedProf, String contacto) {
        this.idMed = idMed;
        this.nombreMed = nombreMed;
        this.cedProf = cedProf;
        this.contacto = contacto;
    }

    public Medico(String nombreMed, String cedProf, String contacto, Blob fotoMed) {
        this.nombreMed = nombreMed;
        this.cedProf = cedProf;
        this.contacto = contacto;
        this.fotoMed = fotoMed;
    }

    public Medico(int idMed, String nombreMed, String cedProf, String contacto, Blob fotoMed) {
        this.idMed = idMed;
        this.nombreMed = nombreMed;
        this.cedProf = cedProf;
        this.contacto = contacto;
        this.fotoMed = fotoMed;
    }

    

    public int getidMed() {
        return idMed;
    }
    public void setidMed(int idMed) {
        this.idMed = idMed;
    }
    public String getNombreMed() {
        return nombreMed;
    }
    public void setNombreMed(String nombreMed) {
        this.nombreMed = nombreMed;
    }
    public String getCedProf() {
        return cedProf;
    }
    public void setCedProf(String cedProf) {
        this.cedProf = cedProf;
    }
    public String getContacto() {
        return contacto;
    }
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Blob getFotoMed() {
        return fotoMed;
    }

    public void setFotoMed(Blob fotoMed) {
        this.fotoMed = fotoMed;
    }



    public int getIdUsuario() {
        return idUsuario;
    }



    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    

    
}
