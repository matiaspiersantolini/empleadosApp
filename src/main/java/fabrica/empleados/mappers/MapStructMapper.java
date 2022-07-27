package fabrica.empleados.mappers;

import fabrica.empleados.api.model.DatosLaboralesDTO;
import fabrica.empleados.model.entities.DatosLaborales;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    DatosLaboralesDTO datosLaboralesToDatosLaboralesDTO(DatosLaborales datosLaborales);
}
