import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Alumno extends Persona {
    /**
     * Atributos propios de la clase Alumno, a parte de los que hereda de la superclase Persona.
     */

    private Curso curso;

    private Profesor tutor;

    private boolean becado;

    private float evaluacion;

    private boolean certificado;

    /**
     * Constructor clase Alumno
     * Curso, evaluacion y certificado al momento de instanciar y crear un alumno tienen valores por defecto.
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
        this.curso = null;
        this.evaluacion = 0;
        this.certificado = false;
    }

    /**
     * Constructor vacío necesario para deserializar un objeto desde un JSON.
     */
    public Alumno(){

    }

    /**
     * Getter del atributo curso.
     * @return Devuelve el valor del atributo curso.
     */
    public Curso getCurso() {
        // TODO Auto-generated return
        return curso;
    }

    /**
     * Getter del atributo tutor.
     * @return Devuelve el valor del atributo tutor.
     */
    public Profesor getTutor() {
        // TODO Auto-generated return
        return tutor;
    }

    /**
     * Getter del atributo becado.
     * @return Devuelve el valor del atributo becado.
     */
    public boolean getBecado() {
        // TODO Auto-generated return
        return becado;
    }

    /**
     * Getter del atributo evaluacion.
     * @return Devuelve el valor del atributo evaluacion.
     */
    public float getEvaluacion() {
        return evaluacion;
    }

    /**
     * Getter del atributo certificado.
     * @return Devuelve el valor del atributo certificado.
     */
    public boolean isCertificado() {
        return certificado;
    }

    /**
     * Setter para darle un nuevo valor al atributo curso.
     * @param curso Curso que se le quiere asignar.
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * Setter para darle un nuevo valor al atributo tutor.
     * @param tutor Tutor que se le quiere asignar.
     */
    public void setTutor(Profesor tutor) {
        this.tutor = tutor;
    }

    /**
     * Setter para darle un nuevo valor al atributo becado.
     * @param becado Valor que se le quiere asignar.
     */
    public void setBecado(boolean becado) {
        this.becado = becado;
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
     * Metodo para la inscripción de un alumno a un curso. EL tutor que s ele asigna debe impartir ese curso.
     * El alumno solo puede estar inscrito en un curso.
     * @param curso Curso al que se inscribe el alumno.
     * @param tutor Tutor que se le asigna al alumno.
     */
    public void inscripcionCurso(Curso curso, Profesor tutor){
        if (getCurso() == null){
            this.curso = curso;
            System.out.println("Alumno "+getNombre()+" "+getApellidos()+ " inscrito en el curso "+curso.getNombre());
            if (tutor.getCurso().getNombre().equalsIgnoreCase(curso.getNombre())){
                this.tutor = tutor;
                System.out.println("Se ha asignado el profesor "+tutor.getNombre()+" "+tutor.getApellidos());
            }else {
                System.out.println("No se ha podido asignar el tutor"+tutor.getNombre()+" "+tutor.getApellidos()+" porque no imparte ese curso.");
            }
        }else {
            System.out.println("Alumno "+getNombre()+" "+getApellidos()+ " no se ha podido inscribir en el curso "+curso.getNombre()+" porque ya está inscrito en un curso.");
        }
    }

    /**
     * Metodo para finalizar un curso. Se tiene que introducir una nota de la evaluación total del curso.
     * Dependiendo si esta nota es mayor o igual que 5 obtendrá el certificado.
     * @param curso Curso que finaliza el alumno.
     */
    public void finalizarCurso(Curso curso){
        Scanner sc = new Scanner(System.in);
        if (getCurso().getNombre().equalsIgnoreCase(curso.getNombre())){
            System.out.println("Introduce la evaluación total del curso: ");
            float evaluacion = sc.nextFloat();
            this.setEvaluacion(evaluacion);
            if (evaluacion >= 5.0){
                this.setCertificado(true);
            }else {
                this.setCertificado(false);
            }
            System.out.println("Curso finalizado con éxito.");
        }else {
            System.out.println("El alumno no está inscrito a ese curso.");
        }
    }

    /**
     * Metodo para mostrar la información del alumno.
     * @return Decvuelve la información del alumno.
     */
    @Override
    public String toString() {
        String alumno = "Alumno" +
                "curso=" + curso +
                ", tutor=" + tutor +
                ", becado=" + becado +
                ", evaluacion=" + evaluacion +
                ", certificado=" + certificado;
        return super.toString()+" "+alumno;
    }
}
