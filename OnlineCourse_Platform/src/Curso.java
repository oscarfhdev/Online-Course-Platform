import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Curso {
    /**
     * Atributosd de la clase Curso.
     */

    private String nombre;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private int horasDuracion;

    private boolean presencial;


    /**
     * Constructo de la clase Curso.
     * @param fechaInicio Fecha en la que se inicia el curso.
     * @param fechaFin Fecha en la que termina el curso.
     * @param horasDuracion Horas de duración del curso.
     * @param presencial Si el curso es de modalidad presencial o no.
     */
    public Curso(final String nombre, final LocalDate fechaInicio, final LocalDate fechaFin, final int horasDuracion, final boolean presencial) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horasDuracion = horasDuracion;
        this.presencial = presencial;
    }

    public Curso(){

    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        // TODO Auto-generated return
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
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

    public boolean isPresencial() {
        return presencial;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setHorasDuracion(int horasDuracion) {
        this.horasDuracion = horasDuracion;
    }

    public void setPresencial(boolean presencial) {
        this.presencial = presencial;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", horasDuracion=" + horasDuracion +
                ", presencial=" + presencial +
                '}';
    }
}
