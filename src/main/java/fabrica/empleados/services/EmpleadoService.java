package fabrica.empleados.services;

import fabrica.empleados.api.model.DatosLaboralesDTO;
import fabrica.empleados.api.model.PostEmpleadoRequest;
import fabrica.empleados.api.model.PostEmpleadoResponse;
import fabrica.empleados.exceptions.EmpleadoNotFoundException;
import fabrica.empleados.mappers.MapStructMapper;
import fabrica.empleados.model.entities.DatosLaborales;
import fabrica.empleados.model.entities.Empleado;
import fabrica.empleados.model.interfaces.IDatosLaborales;
import fabrica.empleados.model.interfaces.IEmpleado;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmpleadoService {

    @Autowired
    private IEmpleado iEmpleado;

    @Autowired
    private IDatosLaborales iDatosLaborales;

    @Autowired
    private MapStructMapper mapper;

    public DatosLaboralesDTO findDatosLaboralesByLegajo(Integer legajo) {
        log.info("2. Buscando datos laborales...");
        DatosLaborales datosLaborales = iDatosLaborales.getDatosLaboralesByLegajo(legajo);
        DatosLaboralesDTO datosLaboralesDTO = mapper.datosLaboralesToDatosLaboralesDTO(datosLaborales);
        if(datosLaboralesDTO == null) throw new EmpleadoNotFoundException();
        return datosLaboralesDTO;
    }

    public PostEmpleadoResponse saveNewEmpleado(PostEmpleadoRequest postEmpleadoRequest) {
        log.info("2. Guardando datos del nuevo empleado...");
        Empleado empleado = mapper.postEmpleadoRequestToEmpleado(postEmpleadoRequest);
        empleado = iEmpleado.save(empleado);
        log.info("3. Numero de legajo del nuevo empleado: {}", empleado.getLegajo());
        return mapper.empleadoToPostEmpleadoResponse(empleado);
    }
}
