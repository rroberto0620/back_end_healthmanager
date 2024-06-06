package mx.uv;

public class Receta {
    private int idRec;
    private String nombreMed;
    private String firmaMed;
    private String contactoMed;
    private float pesoPac;
    private int edadPac;
    private String fecha; 
    private String presArt; 
    private float tempPac;
    private String contenido;
    private int idPaciente;
    private int idMedico;

    public Receta() {

    }

    

    public Receta(String nombreMed, String firmaMed, String contactoMed, float pesoPac, int edadPac, String fecha, String contenido,
            String presArt, float tempPac) {
        this.nombreMed = nombreMed;
        this.firmaMed = firmaMed;
        this.contactoMed = contactoMed;
        this.pesoPac = pesoPac;
        this.edadPac = edadPac;
        this.fecha = fecha;
        this.presArt = presArt;
        this.contenido = contenido;
        this.tempPac = tempPac;
    }



    public Receta(int idRec, String nombreMed, String firmaMed, String contactoMed, float pesoPac, int edadPac,
            String fecha, String presArt,String contenido, float tempPac) {
        this.idRec = idRec;
        this.nombreMed = nombreMed;
        this.firmaMed = firmaMed;
        this.contactoMed = contactoMed;
        this.pesoPac = pesoPac;
        this.edadPac = edadPac;
        this.fecha = fecha;
        this.presArt = presArt;
        this.contenido = contenido;
        this.tempPac = tempPac;
    }



    public Receta(String nombreMed, String firmaMed, String contactoMed, float pesoPac, int edadPac, String fecha,String contenido,
            String presArt, float tempPac, int idPaciente, int idMedico) {
        this.nombreMed = nombreMed;
        this.firmaMed = firmaMed;
        this.contactoMed = contactoMed;
        this.pesoPac = pesoPac;
        this.edadPac = edadPac;
        this.fecha = fecha;
        this.presArt = presArt;
        this.contenido = contenido;
        this.tempPac = tempPac;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
    }



    public Receta(int idRec, String nombreMed, String firmaMed, String contactoMed, float pesoPac, int edadPac,
            String fecha, String presArt, float tempPac,String contenido, int idPaciente, int idMedico) {
        this.idRec = idRec;
        this.nombreMed = nombreMed;
        this.firmaMed = firmaMed;
        this.contactoMed = contactoMed;
        this.pesoPac = pesoPac;
        this.edadPac = edadPac;
        this.fecha = fecha;
        this.presArt = presArt;
        this.tempPac = tempPac;
        this.contenido = contenido;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
    }



    public int getIdRec() {
        return idRec;
    }

    public void setIdRec(int idRec) {
        this.idRec = idRec;
    }

    public String getNombreMed() {
        return nombreMed;
    }

    public void setNombreMed(String nombreMed) {
        this.nombreMed = nombreMed;
    }

    public String getFirmaMed() {
        return firmaMed;
    }

    public void setFirmaMed(String firmaMed) {
        this.firmaMed = firmaMed;
    }

    public String getContactoMed() {
        return contactoMed;
    }

    public void setContactoMed(String contactoMed) {
        this.contactoMed = contactoMed;
    }

    public float getPesoPac() {
        return pesoPac;
    }

    public void setPesoPac(float pesoPac) {
        this.pesoPac = pesoPac;
    }

    public int getEdadPac() {
        return edadPac;
    }

    public void setEdadPac(int edadPac) {
        this.edadPac = edadPac;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPresArt() {
        return presArt;
    }

    public void setPresArt(String presArt) {
        this.presArt = presArt;
    }

    public String getContenido(){
        return contenido;
    }

    public void setContenido(String contenido){
        this.contenido = contenido;
    }

    public float getTempPac() {
        return tempPac;
    }

    public void setTempPac(float tempPac) {
        this.tempPac = tempPac;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    

    
}
