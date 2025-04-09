import java.util.Date;

public class Profesor extends Persona {
    private String titulacion;

    private String especialidad;

    private Curso curso;

    public Profesor(String email, String dni, int edad, Date fechaNacimiento, String apellidos, String nombre) {
        super(email, dni, edad, fechaNacimiento, apellidos, nombre);
    }


    public String getTitulacion() {
        // TODO Auto-generated return
        return titulacion;
    }

    public String getEspecializacion() {
        // TODO Auto-generated return
        return especialidad;
    }

    public Curso getCurso() {
        // TODO Auto-generated return
        return curso;
    }

    public void setTitulacion(final String titulacion) {
        this.titulacion = titulacion;
    }

    public void setEspecializacion(final String especializacion) {
        this.especialidad = especializacion;
    }

    public void setCurso(final Curso curso) {
        this.curso = curso;
    }

}
