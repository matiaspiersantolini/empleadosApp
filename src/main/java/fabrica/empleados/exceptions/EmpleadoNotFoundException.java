package fabrica.empleados.exceptions;

public class EmpleadoNotFoundException extends RuntimeException {

    public EmpleadoNotFoundException(){
        super();
    }

    @Override
    public String getMessage() {
        return "No se encontraron empleados con el valor ingresado";
    }
}
