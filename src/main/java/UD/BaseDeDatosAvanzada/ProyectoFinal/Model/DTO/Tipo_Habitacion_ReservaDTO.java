package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;
/**
 * Clase que define los atributos para el objeto Tipo_Habitacion_ReservaDTO.
 */
@Entity
@Table(name = "tipo_habitacion_reserva")
public class Tipo_Habitacion_ReservaDTO {

    @EmbeddedId
    private Tipo_Habitacion_ReservaPK id;

    public Tipo_Habitacion_ReservaDTO() {
    }

    public Tipo_Habitacion_ReservaDTO(Tipo_Habitacion_ReservaPK id) {
        this.id = id;
    }

    public Tipo_Habitacion_ReservaPK getId() {
        return id;
    }

    public void setId(Tipo_Habitacion_ReservaPK id) {
        this.id = id;
    }

}
