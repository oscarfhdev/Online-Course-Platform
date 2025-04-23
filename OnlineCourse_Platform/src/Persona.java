import java.util.Date;

public abstract class Persona {
    /**
     * AStributos de la superclase Persona.
     * Estos atributos serásn heredados por las subclases Alumno y Profesor.
     */

    private String nombre;

    private String apellidos;

    private Date fechaNacimiento;

    private int edad;

    private String dni;

    private String email;

    /**
     * Constructo de la superclase Persona.
     * @param nombre Nombre de la persona.
     * @param apellidos Apellidos de la persona.
     * @param fechaNacimiento Fecha nacimiento de la persona.
     * @param edad Edad de la persona.
     * @param dni Dni de la persona.
     * @param email Email de la persona.
     */
    public Persona(final String nombre, final String apellidos, final Date fechaNacimiento, final int edad, final String dni, final String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.dni = dni;
        this.email = email;
    }

    public String getNombre() {
        // TODO Auto-generated return
        return nombre;
    }

    public String getApellidos() {
        // TODO Auto-generated return
        return apellidos;
    }

    public Date getFechaNacimiento() {
        // TODO Auto-generated return
        return fechaNacimiento;
    }

    public int getEdad() {
        // TODO Auto-generated return
        return edad;
    }

    public String getDni() {
        // TODO Auto-generated return
        return dni;
    }

    public String getEmail() {
        // TODO Auto-generated return
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
