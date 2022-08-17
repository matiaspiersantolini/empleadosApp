package fabrica.empleados.controller;

import fabrica.empleados.api.EmpleadosApi;
import fabrica.empleados.api.model.DatosLaboralesDTO;
import fabrica.empleados.api.model.PostEmpleadoRequest;
import fabrica.empleados.api.model.PostEmpleadoResponse;
import fabrica.empleados.aspect.annotations.InicioFinLog;
import fabrica.empleados.services.EmpleadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EmpleadoController implements EmpleadosApi {

    @Autowired
    private EmpleadoService empleadoService;

    @Override
    @InicioFinLog
    public ResponseEntity<PostEmpleadoResponse> postEmpleado(PostEmpleadoRequest postEmpleadoRequest) {
        log.info("1. Post -> Ingresando empleado nuevo");
        PostEmpleadoResponse postEmpleadoResponse = empleadoService.saveNewEmpleado(postEmpleadoRequest);
        log.info("3. Numero de legajo del nuevo empleado: {}", postEmpleadoResponse.getLegajo());
        return new ResponseEntity<>(postEmpleadoResponse, HttpStatus.OK);
    }

    @Override
    @InicioFinLog
    public ResponseEntity<DatosLaboralesDTO> getDatosLaboralesByLegajo(Integer legajo) {
        log.info("1. Get -> datos laborales - legajo: {}", legajo);
        DatosLaboralesDTO datosLaborales = empleadoService.findDatosLaboralesByLegajo(legajo);
        return new ResponseEntity<>(datosLaborales, HttpStatus.OK);
    }

    @Override
    @InicioFinLog
    public ResponseEntity<String> deleteEmpleado(Integer legajo) {
        log.info("1. Delete -> legajo: {}", legajo);
        String respuesta = empleadoService.deleteEmpleado(legajo);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
