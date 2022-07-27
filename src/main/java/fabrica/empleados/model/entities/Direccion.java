package fabrica.empleados.model.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "direccion")
@Data
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "calle")
    private String calle;

    @Column(name = "calle_numero")
    private String calleNumero;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "codigo_postal")
    private String codigoPostal;

}
