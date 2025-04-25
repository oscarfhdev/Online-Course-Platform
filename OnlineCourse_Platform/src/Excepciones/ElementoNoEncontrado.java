package Excepciones;

public class ElementoNoEncontrado extends RuntimeException
{
    public ElementoNoEncontrado(String message) {
        super(message);
    }
}
