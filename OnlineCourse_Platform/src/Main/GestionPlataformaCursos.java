package Main;

import Entidades.Alumno;
import Entidades.Curso;
import Entidades.Profesor;
import Excepciones.ElementoNoEncontrado;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase main para realizar la gestión del programa Plataforma de cursos.
 * @author Jaime, Adrián, Óscar, Daniel, Javier
 * @version jdk 23
 */
public class GestionPlataformaCursos {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int opcion = -1;
        File archivoCursosJSON = new File("src/ArchivosJSON/javaCursos.json");
        File archivoAlumnosJSON = new File("src/ArchivosJSON/javaAlumnos.json");
        File archivoProfesoresJSON = new File("src/ArchivosJSON/javaProfesores.json");

        /**
         * ArrayList donde se almacenarán las inatancias que se creen.
         */
        List<Alumno> alumnos = recuperarALumnos(archivoAlumnosJSON);
        List<Curso> cursos = recuperarCursos(archivoCursosJSON);
        List<Profesor> profesores = recuperarProfesores(archivoProfesoresJSON);

        /**
         * Menú principal del porgrama. Se ejecutará al inicio y cuando se termine de realizar una operación vuelve a mostrarse
         * para podewr realizar más operaciones. Saldrá del programa cuando se pulse el número 0.
         */
        do {
            /*System.out.println("Bienvenid@ a la plataforma de gestión de cursos." +
                    "\n Menú principal");
            System.out.println("1. Crear curso: " +
                    "\n2. Crear alumno: " +
                    "\n3. Crear profesor: " +
                    "\n4. Ver cursos: " +
                    "\n5. Ver alumnos: " +
                    "\n6. Ver profesores: " +
                    "\n7. Buscar curso: " +
                    "\n8. Buscar alumno:" +
                    "\n9. Buscar profesor: " +
                    "\n10. Inscribir alumno a un curso: " +
                    "\n11. Impartir curso por un profesor: " +
                    "\n12. Finalizar curso de un alumno: " +
                    "\n0. Salir del programa. ");
            System.out.println("Elige un opción: ");
            opcion = sc.nextInt();
            sc.nextLine();*/

            String input = JOptionPane.showInputDialog(null, "Bienvenid@ a la plataforma de gestión de cursos.\n\n"
                    + "1. Crear curso\n"
                    + "2. Crear alumno\n"
                    + "3. Crear profesor\n"
                    + "4. Ver cursos\n"
                    + "5. Ver alumnos\n"
                    + "6. Ver profesores\n"
                    + "7. Buscar curso\n"
                    + "8. Buscar alumno\n"
                    + "9. Buscar profesor\n"
                    + "10. Inscribir alumno a un curso\n"
                    + "11. Impartir curso por un profesor\n"
                    + "12. Finalizar curso de un alumno\n"
                    + "13. Eliminar curso\n"
                    + "14. Eliminar alumno\n"
                    + "15. Eliminar profesor\n"
                    + "0. Salir del programa\n\n"
                    + "Introduce una opción:");


            // Para controlar si ha cancelado o dejado vacío
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, introduce una opción válida.", "Error", JOptionPane.ERROR_MESSAGE);
                continue; // Vuelve al menú sin salir
            }

            opcion = Integer.parseInt(input);

            try {


                switch (opcion) {

                    case 1:

                        crearCurso(cursos);

                        System.out.println();

                        break;

                    case 2:

                        crearAlumno(alumnos);

                        System.out.println();

                        break;


                    case 3:

                        crearProfesor(profesores);

                        System.out.println();

                        break;

                    case 4:

                        verCursos(cursos);

                        System.out.println();

                        break;

                    case 5:

                        verAlumnos(alumnos);

                        System.out.println();

                        break;

                    case 6:

                        verProfesores(profesores);

                        System.out.println();

                        break;

                    case 7:
                        System.out.println("Introduce el nombre del curso a buscar: ");
                        String nombreCursoBuscar = sc.nextLine();

                        if (buscarCurso(cursos, nombreCursoBuscar).getNombre().equalsIgnoreCase(nombreCursoBuscar)){
                            System.out.println("CURSO ENCONTRADO: ");
                            System.out.println(buscarCurso(cursos, nombreCursoBuscar));
                        }

                        System.out.println();
                        break;

                    case 8:
                        System.out.println("Introduce el nombre del alumno a buscar: ");
                        String nombreAlumnoBuscar = sc.nextLine();

                        System.out.println("Introduce los apellidos del alumno a buscar: ");
                        String apellidosAlumnoBuscar = sc.nextLine();

                        if (buscarAlumno(alumnos, nombreAlumnoBuscar, apellidosAlumnoBuscar).getNombre().equalsIgnoreCase(nombreAlumnoBuscar) && buscarAlumno(alumnos, nombreAlumnoBuscar, apellidosAlumnoBuscar).getApellidos().equalsIgnoreCase(apellidosAlumnoBuscar)){
                            System.out.println("ALUMNO ENCONTRADO: ");
                            System.out.println(buscarAlumno(alumnos, nombreAlumnoBuscar, apellidosAlumnoBuscar));
                        }

                        System.out.println();
                        break;

                    case 9:
                        System.out.println("Introduce el nombre del profesor a buscar: ");
                        String nombreProfesorBuscar = sc.nextLine();

                        System.out.println("Introduce los apellidos del profesor a buscar: ");
                        String apellidosProfesorBuscar = sc.nextLine();

                        if (buscarProfesor(profesores, nombreProfesorBuscar, apellidosProfesorBuscar).getNombre().equalsIgnoreCase(nombreProfesorBuscar) && buscarProfesor(profesores, nombreProfesorBuscar, apellidosProfesorBuscar).getApellidos().equalsIgnoreCase(apellidosProfesorBuscar)){
                            System.out.println("PROFESOR ENCONTRADO: ");
                            System.out.println(buscarProfesor(profesores, nombreProfesorBuscar, apellidosProfesorBuscar));
                        }

                        System.out.println();
                        break;

                    case 10:

                        String nombreAlumnoInscribir;
                        String apellidosAlumnoInscribir;
                        Alumno alumnoInscribir = null;
                        do {
                            System.out.println("¿Qué alumno desea inscribir?");
                            System.out.println("Introduce el nombre: ");
                            nombreAlumnoInscribir = sc.nextLine();

                            System.out.println("Introduce los apellidos: ");
                            apellidosAlumnoInscribir = sc.nextLine();

                            alumnoInscribir = buscarAlumno(alumnos, nombreAlumnoInscribir, apellidosAlumnoInscribir);

                        } while (alumnoInscribir == null);

                        String nombreCursoInscribir;
                        Curso cursoInscribir = null;
                        do {
                            System.out.println("¿Qué curso desea?");
                            nombreCursoInscribir = sc.nextLine();

                            cursoInscribir = buscarCurso(cursos, nombreCursoInscribir);

                        } while (cursoInscribir == null);

                        String nombreProfesorInscribir;
                        String apellidosProfesorInscribir;
                        Profesor profesorInscribir = null;
                        do {
                            System.out.println("¿Qué profesor quiere que tutorize al alumno " + alumnoInscribir.getNombre() + " " + alumnoInscribir.getApellidos() + "?");
                            System.out.println("Introduce el nombre: ");
                            nombreProfesorInscribir = sc.nextLine();

                            System.out.println("Introduce los apellidos: ");
                            apellidosProfesorInscribir = sc.nextLine();

                            profesorInscribir = buscarProfesor(profesores, nombreProfesorInscribir, apellidosProfesorInscribir);
                        } while (profesorInscribir == null);

                        alumnoInscribir.inscripcionCurso(cursoInscribir, profesorInscribir);

                        System.out.println();
                        break;

                    case 11:

                        String nombreProfesorImpartir;
                        String apellidosProfesorImpartir;
                        Profesor profesorImpartir = null;
                        do {
                            System.out.println("¿Qué profesor quiere que imparta un curso?");
                            System.out.println("Introduce el nombre: ");
                            nombreProfesorImpartir = sc.nextLine();

                            System.out.println("Introduce los apellidos: ");
                            apellidosProfesorImpartir = sc.nextLine();

                            profesorImpartir = buscarProfesor(profesores, nombreProfesorImpartir, apellidosProfesorImpartir);
                        } while (profesorImpartir == null);

                        String nombreCursoImpartir;
                        Curso cursoImpartir = null;
                        do {
                            System.out.println("¿Qué curso desea que imparta?");
                            nombreCursoImpartir = sc.nextLine();

                            cursoImpartir = buscarCurso(cursos, nombreCursoImpartir);

                        } while (cursoImpartir == null);

                        profesorImpartir.imparteCurso(cursoImpartir);

                        System.out.println();
                        break;

                    case 12:
                        String nombreAlumnoFinalizar;
                        String apellidosAlumnoFinalizar;
                        Alumno alumnoFinalizar = null;
                        do {
                            System.out.println("¿Qué alumno desea que finalice unn curso?");
                            System.out.println("Introduce el nombre: ");
                            nombreAlumnoFinalizar = sc.nextLine();

                            System.out.println("Introduce los apellidos: ");
                            apellidosAlumnoFinalizar = sc.nextLine();

                            alumnoFinalizar = buscarAlumno(alumnos, nombreAlumnoFinalizar, apellidosAlumnoFinalizar);

                        } while (alumnoFinalizar == null);

                        String nombreCursoFinalizar;
                        Curso cursoFinalizar = null;
                        do {
                            System.out.println("¿Qué curso desea que finalice?");
                            nombreCursoFinalizar = sc.nextLine();

                            cursoFinalizar = buscarCurso(cursos, nombreCursoFinalizar);

                        } while (cursoFinalizar == null);

                        alumnoFinalizar.finalizarCurso(cursoFinalizar);

                        System.out.println();
                        break;

                    case 13:
                        String nombreCursoEliminar;
                        Curso cursoEliminar = null;

                        System.out.println("¿Qué curso desea eliminar?");
                        nombreCursoEliminar = sc.nextLine();

                        cursoEliminar = buscarCurso(cursos, nombreCursoEliminar);

                        eliminarCurso(cursos,cursoEliminar);

                        break;

                    case 14:
                        String nombreAlumnoEliminar;
                        String apellidosAlumnoEliminar;
                        Alumno alumnoEliminar = null;

                        System.out.println("¿Qué alumno desea que finalice unn curso?");
                        System.out.println("Introduce el nombre: ");
                        nombreAlumnoEliminar = sc.nextLine();

                        System.out.println("Introduce los apellidos: ");
                        apellidosAlumnoEliminar = sc.nextLine();

                        alumnoEliminar = buscarAlumno(alumnos, nombreAlumnoEliminar, apellidosAlumnoEliminar);

                        eliminarAlumno(alumnos, alumnoEliminar);

                        System.out.println();
                        break;

                    case 15:
                        String nombreProfesorEliminar;
                        String apellidosProfesorEliminar;
                        Profesor profesorEliminar = null;

                        System.out.println("¿Qué profesor quiere que imparta un curso?");
                        System.out.println("Introduce el nombre: ");
                        nombreProfesorEliminar = sc.nextLine();

                        System.out.println("Introduce los apellidos: ");
                        apellidosProfesorEliminar = sc.nextLine();

                        profesorEliminar = buscarProfesor(profesores, nombreProfesorEliminar, apellidosProfesorEliminar);

                        eliminarProfesor(profesores, profesorEliminar);

                        System.out.println();
                        break;

                    case 0:

                        guardarCursosJSON(cursos, archivoCursosJSON);
                        guardarAlumnosJSON(alumnos, archivoAlumnosJSON);
                        guardarProfesoresJSON(profesores, archivoProfesoresJSON);

                        JOptionPane.showMessageDialog(null,"Guardando y saliendo de la aplicación...", "Información" , JOptionPane.INFORMATION_MESSAGE);
                        //System.out.println("Guardando y saliendo de la aplicación...");
                        break;

                    default:
                        System.out.println("Opción incorrecta.");
                }
            }catch (Exception e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());}
        }while (opcion != 0);
        sc.close();
    }

    /**
     * Metodo para crear curso y agragarlo a una lista de cursos para llevar el control de los cursos creados.
     * @param cursos Lista de cursos donde almacenar el curso creado.
     */
    public static void crearCurso(List<Curso> cursos){
        Scanner sc = new Scanner(System.in);
        //Para el formateo de la fecha.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Introduce el nombre del curso: ");
        String nombreCurso = sc.nextLine();

        System.out.println("Introduce la fecha de inicio del curso (dd/MM/yyyy): ");
        String fehcaInicioCursoTexto = sc.nextLine();
        LocalDate fechaInicioCurso = LocalDate.parse(fehcaInicioCursoTexto, formatter);

        System.out.println("Introduce la fecha de fin del curso (dd/MM/yyyy): ");
        String fehcaFinCursoTexto = sc.nextLine();
        LocalDate fechaFinCurso = LocalDate.parse(fehcaFinCursoTexto, formatter);

        System.out.println("Introduce las horas de duración del curso: ");
        int horasDuracionCurso = sc.nextInt();
        sc.nextLine();

        boolean presencialCurso;

        while (true){
            System.out.println("Introduce si el curso es presencial o no (S/N): ");
            String becadoTexto = sc.nextLine();
            if (becadoTexto.equalsIgnoreCase("S")){
                presencialCurso = true;
                break;
            } else if (becadoTexto.equalsIgnoreCase("N")) {
                presencialCurso = false;
                break;
            }else {
                System.out.println("Opción incorrecta, pulse S o N.");
            }
        }

        Curso curso = new Curso(nombreCurso, fechaInicioCurso, fechaFinCurso, horasDuracionCurso, presencialCurso);
        cursos.add(curso);
    }

    /**
     * Metodo para crear un alumno y guardarlo en una lista para así llevar el control de los alumnos creados.
     * @param alumnos Lista de alumnos donde almacenar el alumno creado.
     */
    public static void crearAlumno(List<Alumno> alumnos){
        Scanner sc = new Scanner(System.in);
        //Para el formateo de la fecha.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Introduce el nombre del alumno: ");
        String nombreAlumno = sc.nextLine();

        System.out.println("Introduce los apellidos del alumno: ");
        String apellidosAlumno = sc.nextLine();

        System.out.println("Introduce la fecha de nacimiento del alumno (dd/MM/yyyy): ");
        String fechaTexto = sc.nextLine();
        LocalDate fechaNacAlumno = LocalDate.parse(fechaTexto, formatter);

        System.out.println("Introduce la edad del alumno: ");
        int edadAlumno = sc.nextInt();
        sc.nextLine();

        System.out.println("Introduce el DNI del alumno: ");
        String dniAlumno = sc.nextLine();

        System.out.println("Introduce el email del alumno: ");
        String emailAlumno = sc.nextLine();

        boolean becadoAlumno;

        while (true) {
            System.out.println("Introduce si el alumno es becado o no (S/N): ");
            String becadoTexto = sc.nextLine();
            if (becadoTexto.equalsIgnoreCase("S")) {
                becadoAlumno = true;
                break;
            } else if (becadoTexto.equalsIgnoreCase("N")) {
                becadoAlumno = false;
                break;
            } else {
                System.out.println("Opción incorrecta, pulse S o N.");
            }
        }

        Alumno alumno = new Alumno(nombreAlumno, apellidosAlumno, fechaNacAlumno, edadAlumno, dniAlumno, emailAlumno, becadoAlumno);
        alumnos.add(alumno);
    }

    /**
     * Metodo para crear un profesor y agragarlo a una lista de cursos para llevar el control de los profesores creados.
     * @param profesores Lista de profesores donde almacenar el profesor creado.
     */
    public static void crearProfesor(List<Profesor> profesores){
        Scanner sc = new Scanner(System.in);
        //Para el formateo de la fecha.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Introduce el nombre del profesor: ");
        String nombreProfesor = sc.nextLine();

        System.out.println("Introduce los apellidos del profesor: ");
        String apellidosProfesor = sc.nextLine();

        System.out.println("Introduce la fecha de nacimiento del profesor (dd/MM/yyyy): ");
        String fechaProfesorTexto = sc.nextLine();
        LocalDate fechaNacPorfesor = LocalDate.parse(fechaProfesorTexto, formatter);

        System.out.println("Introduce la edad del profesor: ");
        int edadProfesor = sc.nextInt();
        sc.nextLine();

        System.out.println("Introduce el DNI del profesor: ");
        String dniProfesor = sc.nextLine();

        System.out.println("Introduce el email del profesor: ");
        String emailProfesor = sc.nextLine();

        System.out.println("Introduce la titulación del profesor: ");
        String titulacionProfesor = sc.nextLine();

        System.out.println("Introduce la especialidad del profesor: ");
        String especialidadProfesor = sc.nextLine();

        Profesor profesor = new Profesor(nombreProfesor, apellidosProfesor, fechaNacPorfesor, edadProfesor, dniProfesor, emailProfesor, titulacionProfesor, especialidadProfesor);
        profesores.add(profesor);
    }

    /**
     * Metodo para mostrar todos los cursos quer hay almacenados en la lista.
     * @param cursos Lista de cursos.
     */
    public static void verCursos(List<Curso> cursos){
        System.out.println("MOSTRANDO CURSOS: ");
        System.out.println("------------------");

        for (Curso curso : cursos){
            System.out.println(curso);
        }
    }

    /**
     * Metodo para mostrar todos los alumnos quer hay almacenados en la lista.
     * @param alumnos Lista de alumnos.
     */
    public static void verAlumnos(List<Alumno> alumnos){
        System.out.println("MOSTRANDO ALUMNOS: ");
        System.out.println("-------------------");

        for (Alumno alumno : alumnos){
            System.out.println(alumno);
        }
    }

    /*Prueba de metodo ver alumnos con JOptionPane
    public static void verAlumnos(List<Entidades.Alumno> alumnos) {
        StringBuilder sb = new StringBuilder(); // Usamos StringBuilder para construir el mensaje
        sb.append("Mostrando alumnos:\n\n");

        for (Entidades.Alumno alumno : alumnos) {
            sb.append(alumno.toString()).append("\n\n"); // Llamas al toString de cada alumno
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Alumnos", JOptionPane.INFORMATION_MESSAGE);

        if (alumnos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay alumnos registrados.", "Lista Vacía", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }*/


    /**
     * Metodo para mostrar todos los profesores quer hay almacenados en la lista.
     * @param profesores Lista de profesores.
     */
    public static void verProfesores(List<Profesor> profesores){
        System.out.println("MOSTRANDO PROFESORES: ");
        System.out.println("----------------------");
        for (Profesor profesor : profesores){
            System.out.println(profesor);
        }
    }

    /**
     * Buscar curso de la lista de cursos a partir de su nombre.
     *
     * @param cursos Lista donde buscar el curso.
     * @param nombreCurso Nombre del curso a buscar.
     * @return Curso encontrado, o excepción con mensaje de que el curso no se encuentra en la lista.
     */
    public static Curso buscarCurso(List<Curso> cursos, String nombreCurso) throws ElementoNoEncontrado{

        boolean cursoEncontrado = false;

        for (Curso curso : cursos){
            if (curso.getNombre().equalsIgnoreCase(nombreCurso)){
                //System.out.println("CURSO ENCONTRADO ");
                cursoEncontrado = true;
                return curso;

            }
        }

        throw new ElementoNoEncontrado("El curso no se encuentra en la lista.");

    }

    /**
     * Buscar alumno de la lista de alumnos a partir de su nombre y apellidos.
     * @param alumnos         Lista donde buscar el alumno.
     * @param nombreALumno    Nombre del alumno a buscar.
     * @param apellidosAlumno Apellidos de alumno a buscar.
     * @return Alumno encontrado, o excepción con mensaje de que el alumno no se encuentra en la lista.
     */
    public static Alumno buscarAlumno(List<Alumno> alumnos, String nombreALumno, String apellidosAlumno) throws ElementoNoEncontrado {

        boolean alumnoEncontrado = false;

        for (Alumno alumno : alumnos){
            if (alumno.getNombre().equalsIgnoreCase(nombreALumno) && alumno.getApellidos().equalsIgnoreCase(apellidosAlumno)){
                //System.out.println("ALUMNO ENCONTRADO ");
                alumnoEncontrado = true;
                return alumno;
            }
        }

        throw new ElementoNoEncontrado("El alumno no se encuentra en la lista.");
    }

    /**
     * Buscar profesor de una lista de profesores a partir de su nombre y apellidos.
     *
     * @param profesores        Lista donde buscar el profesor.
     * @param nombreProfesor    Nombre del profesor a buscar.
     * @param apellidosPorfesor Apellidos de profesor a buscar.
     * @return Profesor encontrado, o excepción con mensaje de que el profesor no se encuentra en la lista.
     */
    public static Profesor buscarProfesor(List<Profesor> profesores, String nombreProfesor, String apellidosPorfesor) throws ElementoNoEncontrado{

        boolean profesorEncontrado = false;

        for (Profesor profesor : profesores){
            if (profesor.getNombre().equalsIgnoreCase(nombreProfesor) && profesor.getApellidos().equalsIgnoreCase(apellidosPorfesor)){
                //System.out.println("PROFESOR ENCONTRADO ");
                profesorEncontrado = true;
                return profesor;
            }
        }

        throw new ElementoNoEncontrado("El profesor no se encuentra en la lista.");

    }


    /**
     * Metodo para guardar los cursos en un archivo JSON para que exita persisntencia de datos.
     * @param cursos Lista de cursos a guardar.
     * @param archivoJSON Archivo donde guardar los cursos.
     */
    public static void guardarCursosJSON(List<Curso> cursos, File archivoJSON){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(archivoJSON, cursos);
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    /**
     * Metodo para guardar los alumnos en un archivo JSON para que exista persistencia de datos.
     * @param alumnos Lista de alumnos a guardar.
     * @param archivoJSON Archivo donde guardar los alumnos.
     */
    public static void guardarAlumnosJSON(List<Alumno> alumnos, File archivoJSON){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(archivoJSON, alumnos);
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    /**
     * Metodo para guardar los profesores en un archivo JSON para que exista persistencia de datos.
     * @param profesores Lista de profesores a guyardar
     * @param archivoJSON Archivo donde guardar los profesores.
     */
    public static void guardarProfesoresJSON(List<Profesor> profesores, File archivoJSON){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(archivoJSON, profesores);
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    /**
     * Metodo para recuperar la lista de cursos desde un archivo JSON.
     * @param archivoJSON Archivo de donde recuperar los cursos.
     * @return Devuelve una lista con los cursos recuperados, en casod e que no haya, devuelve el array vacío.
     * @throws IOException Lanza una excepciónm en caso de fallo.
     */
    public static List<Curso> recuperarCursos(File archivoJSON) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        List<Curso> cursosRecuperados = new ArrayList<>();

        if (archivoJSON.exists()){
            cursosRecuperados = mapper.readValue(archivoJSON, new TypeReference<List<Curso>>() {});
        }else {
            cursosRecuperados = new ArrayList<>();
        }

        return cursosRecuperados;
    }

    /**
     * Metodo para recuperar la lista de alumnos desde un archivo JSON.
     * @param archivoJSON Archivo de donde recuperar los alumnos.
     * @return Devuelve una lista con los alumnos recuperados, en caso de que no haya, devuelve una lista vacía.
     * @throws IOException Lanza excepción en case de fallo.
     */
    public static List<Alumno> recuperarALumnos(File archivoJSON) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        List<Alumno> alumnosRecuperados = new ArrayList<>();

        if (archivoJSON.exists()){
            alumnosRecuperados = mapper.readValue(archivoJSON, new TypeReference<List<Alumno>>() {});
        }else {
            alumnosRecuperados = new ArrayList<>();
        }

        return alumnosRecuperados;
    }

    /**
     * Metodo para recuperar la lista de profesores desde un archivo JSON.
     * @param archivoJSON Archivo de donde recuperar los profesores.
     * @return Devuelve una lista con los profesores recuperados, en caso de que no haya, devuelve una lista vacía.
     * @throws IOException Lanza excepción en caso de fallo.
     */
    public static List<Profesor> recuperarProfesores(File archivoJSON) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        List<Profesor> profesoresRecuperados = new ArrayList<>();

        if (archivoJSON.exists()){
            profesoresRecuperados = mapper.readValue(archivoJSON, new TypeReference<List<Profesor>>() {});
        }else {
            profesoresRecuperados = new ArrayList<>();
        }

        return profesoresRecuperados;
    }

    /**
     * Metodo para eliminar un curso de la lista.
     * @param cursos Lista de cursos donde buscarlo.
     * @param curso Entidades.Curso que se desea eliminar.
     */
    public static void eliminarCurso(List<Curso> cursos, Curso curso){
        cursos.remove(curso);
        System.out.println("Curso "+curso.getNombre()+" eliminado de la lista.");
    }

    /**
     * Metodo para eliminar un alumno de la lista.
     * @param alumnos Lista donde buscarlo.
     * @param alumno Entidades.Alumno que se desea eliminar.
     */
    public static void eliminarAlumno(List<Alumno> alumnos, Alumno alumno){
        alumnos.remove(alumno);
        System.out.println("Alumno "+alumno.getNombre()+" eliminado de la lista.");
    }

    /**
     * Metodo para eliminar un profesor de la lista.
     * @param profesores Lista donde buscarlo.
     * @param profesor Entidades.Profesor que se desea eliminar.
     */
    public static void eliminarProfesor(List<Profesor> profesores, Profesor profesor){
        profesores.remove(profesor);
        System.out.println("Profesor "+profesor.getNombre()+" eliminado de la lista.");
    }

}
