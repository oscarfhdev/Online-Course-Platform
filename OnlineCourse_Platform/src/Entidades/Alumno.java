package Entidades;

import Excepciones.ElementoNoEncontrado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase para representar a la entidad de Alumno. Es una clase que hereda de la superclase Persona.
 * @author Jaime, Adrián, Óscar, Daniel, Javier
 * @version jdk 23
 */
public class Alumno extends Persona {
    /**
     * Atributos propios de la clase Entidades.Alumno, a parte de los que hereda de la superclase Entidades.Persona.
     */

    private ArrayList<Curso> cursos;

    private ArrayList<Curso> cursosRealizados;

    private Profesor tutor;

    private boolean becado;


    /**
     * Constructor clase Entidades.Alumno
     * Entidades.Curso, evaluacion y certificado al momento de instanciar y crear un alumno tienen valores por defecto.
     * Siendo curso null, evaluacon 0 y certificado false.
     * @param nombre Nombre del alumno.
     * @param apellidos Apellidos del alumno.
     * @param fechaNacimiento Fecha nacimiento del alumno.
     * @param edad Edad del alumno.
     * @param dni Dni del alumno.
     * @param email Email del alumno.
     * @param becado SI el alumno es becado o no.
     */
    public Alumno(final String nombre, final String apellidos, final LocalDate fechaNacimiento, final int edad, final String dni, final String email, final boolean becado) {
        super(nombre, apellidos, fechaNacimiento, edad, dni, email);
        this.becado = becado;
        this.cursos = new ArrayList<>();
        this.cursosRealizados = new ArrayList<>();
    }

    /**
     * Constructor vacío necesario para deserializar un objeto desde un JSON.
     */
    public Alumno(){

    }

    /**
     * Getter para obtener los cursos del alumno, solo puede estar realizando uno simultáneamente.
     * @return Devuelve el valor del atributo curso.
     */
    public ArrayList<Curso> getCursos() {
        // TODO Auto-generated return
        return cursos;
    }

    /**
     * Getter para obtener los cursos realizados por el alumno.
     * @return Devuelve el valor del atributo cursosRealizados.
     */
    public ArrayList<Curso> getCursosRealizados() {
        return cursosRealizados;
    }

    /**
     * Getter para obtener el tutor del alumno.
     * @return Devuelve el valor del atributo tutor.
     */
    public Profesor getTutor() {
        // TODO Auto-generated return
        return tutor;
    }

    /**
     * Getter para obtener si el alumno es becado o no.
     * @return Devuelve el valor del atributo becado.
     */
    public String isBecado() {
        // TODO Auto-generated return
        if (becado){
            return "Sí es becado";
        }else {
            return "No es becado";
        }
    }

    /**
     * Setter para asignar un nuevo valor al atributo curso.
     * @param cursos Entidades.Curso que se le quiere asignar.
     */
    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    /**
     * Setter para asignar un nuevo valor al atributo tutor.
     * @param tutor Tutor que se le quiere asignar.
     */
    public void setTutor(Profesor tutor) {
        this.tutor = tutor;
    }

    /**
     * Setter para asignar un nuevo valor al atributo becado.
     * @param becado Valor que se le quiere asignar.
     */
    public void setBecado(boolean becado) {
        this.becado = becado;
    }

    /**
     * Metodo para la inscripción de un alumno a un curso. EL tutor que se le asigna debe impartir ese curso.
     * El alumno solo puede estar inscrito en un curso.
     * @param curso Entidades.Curso al que se inscribe el alumno.
     * @param tutor Tutor que se le asigna al alumno.
     */
    public void inscripcionCurso(Curso curso, Profesor tutor) {
        // Verificamos si el alumno no está ya inscrito en un curso.
        if (!cursos.isEmpty()) {
            System.out.println("El alumno ya está inscrito en el curso " + cursos.getFirst().getNombre() + ". Debe finalizar este curso antes de inscribirse en otro.");
            return; // Sale del metodo si ya tiene un curso
        }

        // Verificamos si el curso ya fue realizado
        boolean cursoRealizado = false;
        for (Curso c : cursosRealizados) {
            if (c.getNombre().equalsIgnoreCase(curso.getNombre())) {
                cursoRealizado = true;
                break;
            }
        }

        // Si el alumno ya lo ha realizado, mostramos el mensaje y terminamos
        if (cursoRealizado) {
            System.out.println("El alumno " + getNombre() + " " + getApellidos() + " ya ha finalizado el curso " + curso.getNombre() + " y no puede inscribirse de nuevo.");
        } else {
            // Verificamos que el profesor tiene un curso asignado y que coincide con el que queremos
            if (tutor.getCurso() != null && tutor.getCurso().getNombre().equalsIgnoreCase(curso.getNombre())) {
                this.cursos.add(curso);
                this.tutor = tutor;
                System.out.println("Alumno " + getNombre() + " " + getApellidos() + " inscrito en el curso " + curso.getNombre());
                System.out.println("Se ha asignado el profesor " + tutor.getNombre() + " " + tutor.getApellidos());
            } else {
                System.out.println("No se ha podido asignar el tutor " + tutor.getNombre() + " " + tutor.getApellidos() + " porque no imparte ese curso.");
            }
        }
    }



    /**
     * Metodo para finalizar un curso. Se tiene que introducir una nota de la evaluación total del curso.
     * Dependiendo si esta nota es mayor o igual que 5 obtendrá el certificado.
     * @param curso Entidades.Curso que finaliza el alumno.
     */
    public void finalizarCurso(Curso curso) {
        Scanner sc = new Scanner(System.in);

        // Buscar el curso real que está en la lista de cursos actuales del alumno
        Curso cursoEnLista = buscarCurso(cursos, curso);

        if (cursoEnLista == curso) {
            System.out.println("Introduce la evaluación total del curso: ");
            String input = sc.nextLine().replace(",", "."); // permite usar coma o punto
            try {
                float evaluacion = Float.parseFloat(input);
                curso.setEvaluacion(evaluacion);

                if (evaluacion >= 5){
                    curso.setCertificado(true);
                }else {
                    curso.setCertificado(false);
                }

                cursos.remove(cursoEnLista);
                cursosRealizados.add(cursoEnLista);

                this.tutor = null;

                System.out.println("Curso finalizado con éxito.");
            } catch (NumberFormatException e) {
                System.out.println("Error: debes introducir un número válido para la evaluación.");
            }
        } else {
            System.out.println("El alumno no está inscrito a ese curso.");
        }
    }


    /**
     * Metodo para buscar un curso en una lista de cursos. Utilizado como apoyo en otros métodos.
     * @param cursos Lista donde buscar el curso.
     * @param cursoBuscado Entidades.Curso buscado.
     * @return Decuelve el curso si lo encuentra, si no lo hace devuelve null.
     * @throws ElementoNoEncontrado
     */
    public static Curso buscarCurso(ArrayList<Curso> cursos, Curso cursoBuscado) {
        for (Curso curso : cursos){
            if (curso.getNombre().equalsIgnoreCase(cursoBuscado.getNombre())){
                return curso;
            }
        }
        return null;
    }

    /**
     * Metodo para mostrar los cursos que está realizando el alumno.
     * @param cursos Lista de cursos.
     * @return Devuelve un String con la información de los cursos, para así mostrar este metodo en el toString.
     */
    public String mostrarCursos(ArrayList<Curso> cursos){
        StringBuilder sb = new StringBuilder();
        for (Curso curso : cursos){
            sb.append(curso.mostrarTodoCurso() +" ");
        }
        return sb.toString();
    }

    /**
     * Metodo para mostrar los cursos rwalizados por el alumno.
     * @param cursosRealizados Lista de cursos.
     * @return Devuelve un String con la información de los cursos realizados, para así mostrar este metodo en el toString.
     */
    public String mostarCursosRealizados(ArrayList<Curso> cursosRealizados){
        StringBuilder sb = new StringBuilder();
        for (Curso curso : cursosRealizados){
            sb.append(curso.mostrarTodoCurso()+" ");
        }
        return sb.toString();
    }

    /**
     * Metodo para en el caso de que no tenga tutor asignado muestre un mensaje o muestre la inromación del tutor en el
     * formato deseado (metodo mostrarTutor).
     * @return Información del tutor asignado para un alumno.
     */
    public String mostrarTutorALumno(){
        if (tutor == null){
            return "No tiene tutor asignado";
        }else {
            return tutor.mostrarTutor();
        }
    }


    /**
     * Metodo para mostrar la información del alumno.
     * @return Decvuelve la información del alumno.
     */
    @Override
    public String toString() {
        String alumno = "\nCurso inscrito: " + mostrarCursos(cursos) +
                "\nCursos realizados: "+ mostarCursosRealizados(cursosRealizados) +
                "\nTutor: "+  mostrarTutorALumno() +
                "\nBecado: "+ isBecado();

        return super.toString()+" "+alumno+
                "\n-------------------------------------";
    }
}
