package Entidades;

import java.time.LocalDate;

/**
 * Clase para representar a la entidad de Curso.
 * @author Jaime, Adrián, Óscar, Daniel, Javier
 * @version jdk 23
 */
public class Curso {
    /**
     * Atributosd de la clase Entidades.Curso.
     */

    private String nombre;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private int horasDuracion;

    private boolean presencial;

    private float evaluacion;

    private boolean certificado;


    /**
     * Constructor de la clase Entidades.Curso.
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
        this.evaluacion = 0;
        this.certificado = false;
    }

    /**
     * Constructor vacío necesario para deserializar un objeto desde un JSON.
     */
    public Curso(){

    }

    /**
     * Getter para obtener el nombre del curso.
     * @return Devuelve el valor del atributo nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter para obtener la fecha de inicio del curso.
     * @return Devuelve el valor del atributo fechaInicio.
     */
    public LocalDate getFechaInicio() {
        // TODO Auto-generated return
        return fechaInicio;
    }

    /**
     * Getter para obtener la fecha del fin del curso.
     * @return Develve el valor del atributo fechaFin.
     */
    public LocalDate getFechaFin() {
        // TODO Auto-generated return
        return fechaFin;
    }

    /**
     * Getter para obtener las horas de duración del curso.
     * @return Devuelve el valor del atributo horasDuracion.
     */
    public int getHorasDuracion() {
        // TODO Auto-generated return
        return horasDuracion;
    }

    /**
     * Getter para obtener si el curso es presencial o no.
     * @return Devuelve el valor del atributo presencial.
     */
    public boolean getPresencial() {
        // TODO Auto-generated return
        return presencial;
    }

    /**
     * Getter para obtener la nota de la evaluación total del curso.
     * @return Devuelve el valor del atributo evaluacion.
     */
    public float getEvaluacion() {
        return evaluacion;
    }

    /**
     * Getter para obtener si obtuvo el certificado o no, se obtendrá a partir de la nota de evaluación..
     * @return Devuelve el valor del atributo certificado.
     */
    public String isCertificado() {
        if (certificado){
            return "Sí ha obtenido el certificado.";
        }else {
            return "No ha obtenido el certificado";
        }
    }

    /**
     * Getter para obtener si el curso es presencial o no.
     * @return Devuelve el valor del atributo presencial.
     */
    public String isPresencial() {
        if (presencial){
            return "Sí es presencial";
        }else {
            return "No es presencial";
        }
    }

    /**
     * Setter para asignar un nuevo nombre al curso.
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setter para asignar una nueva fecha de inicio al curso.
     * @param fechaInicio Nueva fecha de inicio.
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Setter para asignar una nueva fecha de fin al curso.
     * @param fechaFin Nueva fecha de fin.
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Setter para asignar un nuveo valor de horas de duración del curso.
     * @param horasDuracion Nuevo valor de horas de duración.
     */
    public void setHorasDuracion(int horasDuracion) {
        this.horasDuracion = horasDuracion;
    }

    /**
     * Setter para asignarle si es presencial o no.
     * @param presencial Nuevo valor true o false.
     */
    public void setPresencial(boolean presencial) {
        this.presencial = presencial;
    }

    /**
     * Setter para darle un nuevo valor al atributo evaluacion.
     * @param evaluacion Valor que se le quiere asignar.
     */
    public void setEvaluacion(float evaluacion) {
        this.evaluacion = evaluacion;
    }

    /**
     * Setter para darle un nuevo valor al atributo certificado.
     * @param certificado Valor que se le quiere asignar.
     */
    public void setCertificado(boolean certificado) {
        this.certificado = certificado;
    }


    /**
     * Este metodo muestra toda la información incluido la evaluación y certificado.
     * Será usado para mostrar la información del curso de un alumno.
     * @return
     */
    public String mostrarTodoCurso(){
        return "| Nombre: " + nombre +
                "| Fecha inicio: "+ fechaInicio+
                "| Fecha fin: "+fechaFin+
                "| Horas de duración: "+ horasDuracion+" horas"+
                "| Presencial: "+ isPresencial() +
                "| Evaluación: "+evaluacion+
                "| Certificado: "+isCertificado();
    }

    /**
     * Metodo para mostrar la información deseada de un curso para un profesor.
     * @return Información de un curso para un profesor.
     */
    public String mostrarCursoProfesor(){
        return "| Nombre: " + nombre +
                "| Fecha inicio: "+ fechaInicio+
                "| Fecha fin: "+fechaFin+
                "| Horas de duración: "+ horasDuracion+" horas"+
                "| Presencial: "+ isPresencial();
    }

    /**
     * Metodo toString para mostrar la información del curso.
     * Este metodo no muestra la evluación ni el certificado.
     * @return
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nFecha inicio: "+ fechaInicio+
                "\nFecha fin: "+fechaFin+
                "\nHoras de duración: "+ horasDuracion+" horas"+
                "\nPresencial: "+ isPresencial() +
                "\n-------------------------------------";
    }
}
