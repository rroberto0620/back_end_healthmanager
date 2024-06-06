package mx.uv;

import java.sql.Blob;

public class Paciente {
    private int idPac;
    private String nombre;
    private int edad;
    private float peso;
    private String contacto;
    private Blob fotoPac;
    private int idUsuario;

    public Paciente(){
        
    }

    public Paciente(String nombre, int edad, float peso, String contacto, int idUsuario) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.contacto = contacto;
        this.idUsuario = idUsuario;
    }



    public Paciente(String nombre, int edad, float peso, String contacto, Blob fotoPac, int idUsuario) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.contacto = contacto;
        this.fotoPac = fotoPac;
        this.idUsuario = idUsuario;
    }

    public Paciente(int idPac, String nombre, int edad, float peso, String contacto, int idUsuario) {
        this.idPac = idPac;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.contacto = contacto;
        this.idUsuario = idUsuario;
    }



    public Paciente(int idPac, String nombre, int edad, float peso, String contacto, Blob fotoPac, int idUsuario) {
        this.idPac = idPac;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.contacto = contacto;
        this.fotoPac = fotoPac;
        this.idUsuario = idUsuario;
    }



    public Paciente(int idPac, String nombre, int edad, float peso, String contacto) {
        this.idPac = idPac;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.contacto = contacto;
    }

    public Paciente(String nombre, int edad, float peso, String contacto) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.contacto = contacto;
    }

    

    public Paciente(String nombre, int edad, float peso, String contacto, Blob fotoPac) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.contacto = contacto;
        this.fotoPac = fotoPac;
    }

    public Paciente(int idPac, String nombre, int edad, float peso, String contacto, Blob fotoPac) {
        this.idPac = idPac;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.contacto = contacto;
        this.fotoPac = fotoPac;
    }

    

    public int getIdPac() {
        return idPac;
    }

    public void setIdPac(int idPac) {
        this.idPac = idPac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Blob getFotoPac() {
        return fotoPac;
    }

    public void setFotoPac(Blob fotoPac) {
        this.fotoPac = fotoPac;
    }



    public int getIdUsuario() {
        return idUsuario;
    }



    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    
}
