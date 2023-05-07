package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table
public class Tipo_Habitacion_ReservaDTO {

    @Id
    private long id_tipo_habitacion;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_ureserva")
    private ReservaDTO id_reserva;


}
