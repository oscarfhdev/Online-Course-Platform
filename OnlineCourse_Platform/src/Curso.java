import java.util.Date;

public class Curso {
    /**
     * Atributosd de la clase Curso.
     */

    private Date fechaInicio;

    private Date fechaFin;

    private int horasDuracion;

    private boolean presencial;


    /**
     * Constructo de la clase Curso.
     * @param fechaInicio Fecha en la que se inicia el curso.
     * @param fechaFin Fecha en la que termina el curso.
     * @param horasDuracion Horas de duración del curso.
     * @param presencial Si el curso es de modalidad presencial o no.
     */
    public Curso(final Date fechaInicio, final Date fechaFin, final int horasDuracion, final boolean presencial) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horasDuracion = horasDuracion;
        this.presencial = presencial;
    }

    public Date getFechaInicio() {
        // TODO Auto-generated return
        return fechaInicio;
    }

    public Date getFechaFin() {
        // TODO Auto-generated return
        return fechaFin;
    }

    public int getHorasDuracion() {
        // TODO Auto-generated return
        return horasDuracion;
    }

    public boolean getPresencial() {
        // TODO Auto-generated return
        return presencial;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setHorasDuracion(int horasDuracion) {
        this.horasDuracion = horasDuracion;
    }

    public void setPresencial(boolean presencial) {
        this.presencial = presencial;
    }
}
