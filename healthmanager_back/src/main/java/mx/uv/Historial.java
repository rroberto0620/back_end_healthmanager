package mx.uv;

import java.sql.Date;

public class Historial {
    /*CREATE TABLE Historial (
    idHistorial INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    fk_idPac INT NOT NULL,
    fk_idRec INT NOT NULL,
    FOREIGN KEY (fk_idPac) REFERENCES Paciente(idPac),
    FOREIGN KEY (fk_idRec) REFERENCES Receta(idRec) ); */
    private int idHistorial;
    private Date fecha;
    private int idRec;
    private int idPac;

    

    public Historial(Date fecha, int idRec, int idPac) {
        this.fecha = fecha;
        this.idRec = idRec;
        this.idPac = idPac;
    }
    public Historial(int idHistorial, Date fecha, int idRec, int idPac) {
        this.idHistorial = idHistorial;
        this.fecha = fecha;
        this.idRec = idRec;
        this.idPac = idPac;
    }
    public int getIdHistorial() {
        return idHistorial;
    }
    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getIdRec() {
        return idRec;
    }
    public void setIdRec(int idRec) {
        this.idRec = idRec;
    }
    public int getIdPac() {
        return idPac;
    }
    public void setIdPac(int idPac) {
        this.idPac = idPac;
    }

    
}
