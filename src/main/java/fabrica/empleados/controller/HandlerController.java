package fabrica.empleados.controller;

import fabrica.empleados.api.model.ErrorResponse;
import fabrica.empleados.exceptions.EmpleadoNotFoundException;
import fabrica.empleados.model.entities.Empleado;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class HandlerController {

    @ResponseBody
    @ExceptionHandler(EmpleadoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse empleadoNotFoundResponse(EmpleadoNotFoundException ex) {
        log.info("[FIN] No se encotraron datos.");
        ErrorResponse errorResponse = new ErrorResponse().mensaje("No encontrado").detalle(ex.getMessage());
        return errorResponse;
    }
}
