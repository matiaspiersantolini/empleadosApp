package fabrica.empleados.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
@Data
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer legajo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "datos_personales_id")
    private DatosPersonales datosPersonales;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "datos_laborales_id")
    private DatosLaborales datosLaborales;
}
