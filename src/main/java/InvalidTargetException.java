public class InvalidTargetException extends RuntimeException{
    public InvalidTargetException(){
        super("No se puede realizar una acción a un objetivo nulo");
    }
}
