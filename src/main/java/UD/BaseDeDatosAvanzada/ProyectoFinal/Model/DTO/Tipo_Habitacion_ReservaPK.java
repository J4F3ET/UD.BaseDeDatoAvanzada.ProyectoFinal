package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Embeddable Clase que define los atributos para el objeto Tipo_Habitacion_ReservaPK.
 * @Column indica que el atributo se mapea a la columna con el mismo nombre
 * @ManyToOne indica la relación muchos a uno
 * @JoinColumn indica el nombre de la columna que hace referencia a la clave primaria de la tabla referenciada
 * Clase que representa la llave primaria de la tabla Tipo_Habitacion_Reserva de la base de datos.
 */
@Embeddable
public class Tipo_Habitacion_ReservaPK  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "tipo_habitacion")
    private short tipo_habitacion;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ReservaDTO.class)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    private ReservaDTO id_reserva;

    public Tipo_Habitacion_ReservaPK() {
    }

    public Tipo_Habitacion_ReservaPK(short tipo_habitacion, ReservaDTO id_reserva) {
        this.tipo_habitacion = tipo_habitacion;
        this.id_reserva = id_reserva;
    }

    public short getTipo_habitacion() {
        return tipo_habitacion;
    }

    public void setTipo_habitacion(short tipo_habitacion) {
        this.tipo_habitacion = tipo_habitacion;
    }

    public ReservaDTO getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(ReservaDTO id_reserva) {
        this.id_reserva = id_reserva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tipo_Habitacion_ReservaPK that = (Tipo_Habitacion_ReservaPK) o;
        return tipo_habitacion == that.tipo_habitacion && Objects.equals(id_reserva, that.id_reserva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo_habitacion, id_reserva);
    }
}
