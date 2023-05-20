package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;
/**
 * @Entity Clase que define los atributos para el objeto Tipo_Habitacion_ReservaDTO.
 * @Table indica que la clase es una entidad y que se mapea a una tabla de base de datos
 * @EmbeddedId indica que la clase es una clave primaria compuesta
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
