package fabrica.empleados.controller;

import fabrica.empleados.api.model.ErrorResponse;
import fabrica.empleados.exceptions.DataBaseException;
import fabrica.empleados.exceptions.EmpleadoNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    ErrorResponse empleadoNotFoundHandler(EmpleadoNotFoundException ex) {
        log.info("[FIN] No se encotraron datos.");
        return new ErrorResponse().mensaje(ex.getLocalizedMessage()).detalle(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(DataBaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ErrorResponse dataBaseHandler(DataBaseException ex) {
        String detalle = ex.getMessage() != null ? ex.getMessage(): "Error al intentar realizar operaciones con la base de datos";
        log.info("[FIN] Error en la base de datos. | {}", detalle);
        return new ErrorResponse().mensaje(ex.getLocalizedMessage()).detalle(detalle);
    }
}
