package fabrica.empleados.model.interfaces;

import fabrica.empleados.model.entities.DatosLaborales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IDatosLaborales extends JpaRepository<DatosLaborales, Integer> {

    @Query("SELECT dl FROM DatosLaborales dl " +
            "INNER JOIN Empleado e on e.datosLaborales.id = dl.id " +
            "WHERE e.legajo = :legajo")
    DatosLaborales getDatosLaboralesByLegajo(@Param("legajo") Integer legajo);
}
