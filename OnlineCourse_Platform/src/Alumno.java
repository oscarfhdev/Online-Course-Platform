import java.util.Date;

public class Alumno extends Persona {
    /**
     * Atributos propios de la clase Alumno, a parte de los que hereda de la superclase Persona.
     */

    private Curso curso;

    private Profesor tutor;

    private boolean becado;

    private float evaluacion;

    private boolean certificado;

    /**
     * Constructor clase Alumno
     * Curso, evaluacion y certificado al momento de instanciar y crear un alumno tienen valores por defecto.
     * Siendo curso null, evaluacon 0 y certificado false.
     * @param nombre Nombre del alumno.
     * @param apellidos Apellidos del alumno.
     * @param fechaNacimiento Fecha nacimiento del alumno.
     * @param edad Edad del alumno.
     * @param dni Dni del alumno.
     * @param email Email del alumno.
     * @param becado SI el alumno es becado o no.
     */
    public Alumno(final String nombre, final String apellidos, final Date fechaNacimiento, final int edad, final String dni, final String email, final boolean becado) {
        super(nombre, apellidos, fechaNacimiento, edad, dni, email);
        this.becado = becado;
        this.curso = null;
        this.evaluacion = 0;
        this.certificado = false;
    }


    public Curso getCurso() {
        // TODO Auto-generated return
        return curso;
    }

    public Profesor getTutor() {
        // TODO Auto-generated return
        return tutor;
    }

    public boolean getBecado() {
        // TODO Auto-generated return
        return becado;
    }

    public float getEvaluacion() {
        return evaluacion;
    }

    public boolean isCertificado() {
        return certificado;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setTutor(Profesor tutor) {
        this.tutor = tutor;
    }

    public void setBecado(boolean becado) {
        this.becado = becado;
    }

    public void setEvaluacion(float evaluacion) {
        this.evaluacion = evaluacion;
    }

    public void setCertificado(boolean certificado) {
        this.certificado = certificado;
    }
}
