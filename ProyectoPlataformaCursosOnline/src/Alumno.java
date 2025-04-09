import java.util.Date;

public class Alumno extends Persona {
    private Curso curso;

    private Profesor tutor;

    private boolean becado;

    public Alumno(String email, String dni, int edad, Date fechaNacimiento, String apellidos, String nombre) {
        super(email, dni, edad, fechaNacimiento, apellidos, nombre);
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

    public void setCurso(final Curso curso) {
        this.curso = curso;
    }

    public void setTutor(final Profesor profesor) {
        this.tutor = tutor;
    }

    public void setBecado(final boolean beca) {
        this.becado = beca;
    }

}
