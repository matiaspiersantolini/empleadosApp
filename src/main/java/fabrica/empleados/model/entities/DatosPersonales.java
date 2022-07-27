package fabrica.empleados.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "datos_laborales")
@Data
public class DatosPersonales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documento_id")
    private Documento documento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;

    @Column(name = "telefono")
    private String telefono;
}
