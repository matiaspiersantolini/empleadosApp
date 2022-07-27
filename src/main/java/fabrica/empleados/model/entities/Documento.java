package fabrica.empleados.model.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "documento")
@Data
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "numero")
    private String numero;


}
