package fabrica.empleados.model.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "datos_laborales")
@Data
public class DatosLaborales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "sector")
    private String sector;

    @Column(name = "puesto")
    private String puesto;

    @Column(name = "salario")
    private String salario;

    @Column(name = "antiguedad")
    private String antiguedad;
}
