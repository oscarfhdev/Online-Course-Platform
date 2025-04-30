package Entidades;

import java.time.LocalDate;

/**
 * Clase para representar a la entidad de Profesor. Es una clase que hereda de la superclase Persona.
 * @author Jaime, Adrián, Óscar, Daniel, Javier
 * @version jdk 23
 */
public class Profesor extends Persona {
    /**
     * Atributos propios de la clase Entidades.Profesor, a parte de los que hereda de la superclase Entidades.Persona.
     */

    private String titulacion;

    private String especialidad;

    private Curso curso;

    /**
     * Constructorr de la clase Entidades.Profesor.
     * Entidades.Curso al momento de instanciar un profesor comienza siendo null.
     * @param nombre Nombre del profesor.
     * @param apellidos Apellidos del Porfesor.
     * @param fechaNacimiento Fehca nacimiento del profesor.
     * @param edad Edad del profesor.
     * @param dni Dni del profesor.
     * @param email Email del profesor.
     * @param titulacion Titulación del profesor.
     * @param especialidad Especialidad del profesor.
     */
    public Profesor(final String nombre, final String apellidos, final LocalDate fechaNacimiento, final int edad, final String dni, final String email , final String titulacion, final String especialidad) {
        super(nombre, apellidos, fechaNacimiento, edad, dni, email);
        this.titulacion = titulacion;
        this.especialidad = especialidad;
    }

    /**
     * Constructor vacío necesario para deserializar un objeto desde un JSON.
     */
    public Profesor(){

    }

    /**
     * Getter para obtener la titulación del profesor.
     * @return Devuelve el valor del atributo titulacion.
     */
    public String getTitulacion() {
        // TODO Auto-generated return
        return titulacion;
    }

    /**
     * Getter para obtener la especialidad del profesor.
     * @return Devuelve el valor del atributo especialidad.
     */
    public String getEspecialidad() {
        // TODO Auto-generated return
        return especialidad;
    }

    /**
     * Getter para obtener elcurso que imparte el profesor.
     * @return Devuelve el valor del atributo curso.
     */
    public Curso getCurso() {
        // TODO Auto-generated return
        return curso;
    }

    /**
     * Setter para asignarle una nueva titulación al profesor.
     * @param titulacion Nueva titulación.
     */
    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    /**
     * Setter para asignarle nueva especialidad al profesor.
     * @param especialidad Devuelve el valor de especialidad.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Setter para asignarle un nuveo curso que imparte el profesor.
     * @param curso Nuevo curso.
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * Metodo para que un profesor imparta un curso.
     * Un profesor solo puede impartir un curso.
     * @param curso Entidades.Curso a impartir.
     */
    public void imparteCurso(Curso curso){
        if (this.curso == null){
            this.curso = curso;
            System.out.println("Profesor "+getNombre()+" "+getApellidos()+" ahora imparte el curso "+curso.getNombre());
        }else {
            System.out.println("Profesor "+getNombre()+" "+getApellidos()+ " no puede impartir el curso "+curso.getNombre()+" porque ya está impartiendo otro curso.");
        }
    }

    /**
     * Metodo para mostrar un mensaje en caso de que el curso del profesor sea null, o mostrar
     * la información deseada de un curso para un profesor (metodo mostrarCursoProfesor).
     * @return Información de un curso de un profesor.
     */
    public String isCurso(){
        if (curso == null){
            return "No imparte ningún curso";
        }else {
            return curso.mostrarCursoProfesor();
        }
    }

    /**
     * Metodo para mostrar la información deseada de un profesor para un alumno(tutor).
     * @return Información de un profesor para un alumno.
     */
    public String mostrarTutor(){
        return  "| Nombre: "+getNombre()+
                "| Apellidos: "+getApellidos()+
                "| Fecha de nacimiento: "+getFechaNacimiento()+
                "| Edad: "+getEdad()+
                "| DNI: "+getDni()+
                "| Email: "+getEmail()+
                "| Titulacion: "+titulacion+
                "| Especialidad: "+especialidad+
                "| Curso: { "+ isCurso()+" }";
    }

    /**
     * metodo toString para mostrar la información de un profesor.
     * @return
     */
    @Override
    public String toString() {
        String profesor = "\nTitulación: "+titulacion+
                "\nEspecialidad: "+especialidad+
                "\nCurso: { "+ isCurso()+" }";
        return super.toString()+" "+profesor+
                "\n-------------------------------------";
    }
}
