package fabrica.empleados.model.interfaces;

import fabrica.empleados.model.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IEmpleado extends JpaRepository<Empleado, Integer> {

    @Query("SELECT e FROM Empleado e WHERE e.datosPersonales.documento.numero = :dni")
    Empleado findByDNI(@Param("dni") String dni);
}
