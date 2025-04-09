import java.util.Date;

public abstract class Persona {
    private String nombre;

    private String apellidos;

    private Date fechaNacimiento;

    private int edad;

    private String dni;

    private String email;


    public Persona(String email, String dni, int edad, Date fechaNacimiento, String apellidos, String nombre) {
        this.email = email;
        this.dni = dni;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    public String getNombre() {
        // TODO Auto-generated return
        return null;
    }

    public String getApellidos() {
        // TODO Auto-generated return
        return null;
    }

    public Date getFechaNacimiento() {
        // TODO Auto-generated return
        return null;
    }

    public int getEdad() {
        // TODO Auto-generated return
        return 0;
    }

    public String getDni() {
        // TODO Auto-generated return
        return null;
    }

    public String getEmail() {
        // TODO Auto-generated return
        return null;
    }

    public void setNombre(final String nombre) {
    }

    public void setApellidos(final String apellidos) {
    }

    public void setFechaNacimiento(final Date fechaNacimiento) {
    }

    public void setEdad(final int edad) {
    }

    public void setDni(final String dni) {
    }

    public void setEmail(final String email) {
    }

}
