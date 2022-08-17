package fabrica.empleados.exceptions;

public class DataBaseException extends RuntimeException {

    public DataBaseException(){
        super();
    }

    public DataBaseException(String cause){
        super(cause);
    }

    @Override
    public String getLocalizedMessage() {
        return "Error Interno";
    }
}
