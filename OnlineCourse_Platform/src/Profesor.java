import java.util.Date;

public class Profesor extends Persona {
    /**
     * Atributos propios de la clase Profesor, a parte de los que hereda de la superclase Persona.
     */

    private String titulacion;

    private String especialidad;

    private Curso curso;

    /**
     * Constructorr de la clase Profesor.
     * Curso al momento de instanciar un profesor comienza siendo null.
     * @param nombre Nombre del profesor.
     * @param apellidos Apellidos del Porfesor.
     * @param fechaNacimiento Fehca nacimiento del profesor.
     * @param edad Edad del profesor.
     * @param dni Dni del profesor.
     * @param email Email del profesor.
     * @param titulacion Titulación del profesor.
     * @param especialidad Especialidad del profesor.
     */
    public Profesor(final String nombre, final String apellidos, final Date fechaNacimiento, final int edad, final String dni, final String email , final String titulacion, final String especialidad) {
        super(nombre, apellidos, fechaNacimiento, edad, dni, email);
        this.titulacion = titulacion;
        this.especialidad = especialidad;
        this.curso = null;
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

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
