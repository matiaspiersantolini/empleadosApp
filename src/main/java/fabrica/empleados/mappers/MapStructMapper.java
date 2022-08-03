package fabrica.empleados.mappers;

import fabrica.empleados.api.model.DatosLaboralesDTO;
import fabrica.empleados.api.model.PostEmpleadoRequest;
import fabrica.empleados.api.model.PostEmpleadoResponse;
import fabrica.empleados.model.entities.DatosLaborales;
import fabrica.empleados.model.entities.Empleado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    DatosLaboralesDTO datosLaboralesToDatosLaboralesDTO(DatosLaborales datosLaborales);

    Empleado postEmpleadoRequestToEmpleado(PostEmpleadoRequest postEmpleadoRequest);

    PostEmpleadoResponse empleadoToPostEmpleadoResponse(Empleado empleado);
}
