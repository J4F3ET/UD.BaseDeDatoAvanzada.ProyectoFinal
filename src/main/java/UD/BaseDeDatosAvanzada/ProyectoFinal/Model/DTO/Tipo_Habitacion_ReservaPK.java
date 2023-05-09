package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Tipo_Habitacion_ReservaPK  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "tipo_habitacion")
    private long tipo_habitacion;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ReservaDTO.class)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_ureserva")
    private ReservaDTO id_reserva;

    public Tipo_Habitacion_ReservaPK() {
    }

    public Tipo_Habitacion_ReservaPK(long tipo_habitacion, ReservaDTO id_reserva) {
        this.tipo_habitacion = tipo_habitacion;
        this.id_reserva = id_reserva;
    }

    public long getTipo_habitacion() {
        return tipo_habitacion;
    }

    public void setTipo_habitacion(long tipo_habitacion) {
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
