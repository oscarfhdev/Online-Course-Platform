package Entidades;

import java.time.LocalDate;

/**
 * Clase para representar a la entidad de Persona. De esta clase heredarán las subclases Alumno y Profesor.
 * @author Jaime, Adrián, Óscar, Daniel, Javier
 * @version jdk 23
 */
public class Persona {
    /**
     * Atributos de la superclase Entidades.Persona.
     * Estos atributos serásn heredados por las subclases Entidades.Alumno y Entidades.Profesor.
     */

    private String nombre;

    private String apellidos;

    private LocalDate fechaNacimiento;

    private int edad;

    private String dni;

    private String email;

    /**
     * Constructo de la superclase Entidades.Persona.
     * @param nombre Nombre de la persona.
     * @param apellidos Apellidos de la persona.
     * @param fechaNacimiento Fecha nacimiento de la persona.
     * @param edad Edad de la persona.
     * @param dni Dni de la persona.
     * @param email Email de la persona.
     */
    public Persona(final String nombre, final String apellidos, final LocalDate fechaNacimiento, final int edad, final String dni, final String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.dni = dni;
        this.email = email;
    }

    /**
     * Constructor vacío necesario para deserializar un objeto desde un JSON.
     */
    public Persona() {

    }

    /**
     * Getter para obtener el nombre de una persona.
     * @return Devuelve el valor del atributo nombre.
     */
    public String getNombre() {
        // TODO Auto-generated return
        return nombre;
    }

    /**
     * Getter para obtener los apellidos de una persona.
     * @return Devuelve el valor del atributo apellidos.
     */
    public String getApellidos() {
        // TODO Auto-generated return
        return apellidos;
    }

    /**
     * Getter para obtener la fecha de nacimiento de una persona.
     * @return Devuelve el valor del atributo fechaNacimiento.
     */
    public LocalDate getFechaNacimiento() {
        // TODO Auto-generated return
        return fechaNacimiento;
    }

    /**
     * Getter para obtener la edad de una persona.
     * @return Devuelve el valor del atributo edad.
     */
    public int getEdad() {
        // TODO Auto-generated return
        return edad;
    }

    /**
     * Getter para obtener el DNI de una persona.
     * @return Devuelve el valor del atributo dni.
     */
    public String getDni() {
        // TODO Auto-generated return
        return dni;
    }

    /**
     * Getter para obtener el email de una persona.
     * @return Devuelve el valor del atributo email.
     */
    public String getEmail() {
        // TODO Auto-generated return
        return email;
    }

    /**
     * Setter para asignar un nuevo nombre a una perosna.
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setter para asignar unos nuevos apellidos a una perosna.
     * @param apellidos Nuevos apellidos.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Setter para asignar una nueva fecha de nacimiento a una perosna.
     * @param fechaNacimiento Nueva fecha de nacimiento.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Setter para asignar una nueva edad a una perosna.
     * @param edad Nueva edad.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Setter para asignar un nuevo DNI a una perosna.
     * @param dni Nuevo DNI.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Setter para asignar un nuevo email a una perosna.
     * @param email Nuevo email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo toString para mostrtar la información de una persona.
     * @return
     */
    @Override
    public String toString() {
        return
                "Nombre: "+nombre+
                "\nApellidos: "+apellidos+
                "\nFecha de nacimiento: "+fechaNacimiento+
                "\nEdad: "+edad+
                "\nDNI: "+dni+
                "\nEmail: "+email;
    }
}
