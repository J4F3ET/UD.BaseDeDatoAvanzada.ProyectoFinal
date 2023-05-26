package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecibirPK implements Serializable {
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    private ReservaDTO reserva;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = HabitacionDTO.class)
    @JoinColumns({
            @JoinColumn(name = "numero_habitacion", referencedColumnName = "numero_habitacion"),
            @JoinColumn(name = "piso", referencedColumnName = "piso"),
            @JoinColumn(name = "rnt_hotel", referencedColumnName = "rnt_hotel")
    })
    @JsonBackReference
    private HabitacionDTO habitacion;

    public RecibirPK() {
    }

    public ReservaDTO getReserva() {
        return reserva;
    }

    public void setReserva(ReservaDTO reserva) {
        this.reserva = reserva;
    }

    public HabitacionDTO getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(HabitacionDTO habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecibirPK recibirPK = (RecibirPK) o;
        return Objects.equals(reserva, recibirPK.reserva) && Objects.equals(habitacion, recibirPK.habitacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reserva, habitacion);
    }
}
