import java.util.Date;

public class Curso {
    private Date fechaInicio;

    private Date fechaFin;

    private int horasDuracion;

    private boolean presencial;

    private String ciudad;

    public Alumno alumno;

    public Profesor profesor;

    public Curso(final Date fechaInicio, final Date fechaFin, final int horasDuracion, final boolean presencial, final String ciudad) {
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

    public String getCiudad() {
        // TODO Auto-generated return
        return ciudad;
    }

    public void setFechaInicio(final Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(final Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setHorasDuracion(final int horas) {
        this.horasDuracion = horas;
    }

    public void setPresencial(final boolean presencial) {
        this.presencial = presencial;
    }

    public void setCiudad(final String ciudad) {
        this.ciudad = ciudad;
    }

}
