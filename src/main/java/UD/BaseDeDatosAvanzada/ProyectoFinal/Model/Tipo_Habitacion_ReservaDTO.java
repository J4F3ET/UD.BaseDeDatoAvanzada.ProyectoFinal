package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_habitacion_reserva")
public class Tipo_Habitacion_ReservaDTO {

    @Id
    private long id_tipo_habitacion;

    @Id
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ReservaDTO.class)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_ureserva")
    private ReservaDTO id_reserva;

    public Tipo_Habitacion_ReservaDTO() {
    }
    public Tipo_Habitacion_ReservaDTO(long id_tipo_habitacion, ReservaDTO id_reserva) {
        this.id_tipo_habitacion = id_tipo_habitacion;
        this.id_reserva = id_reserva;
    }

    public long getId_tipo_habitacion() {
        return id_tipo_habitacion;
    }

    public void setId_tipo_habitacion(long id_tipo_habitacion) {
        this.id_tipo_habitacion = id_tipo_habitacion;
    }

    public ReservaDTO getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(ReservaDTO id_reserva) {
        this.id_reserva = id_reserva;
    }
    @Override
    public String toString() {
        return "Tipo_Habitacion_ReservaDTO [id_reserva=" + id_reserva + ", id_tipo_habitacion=" + id_tipo_habitacion
                + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Tipo_Habitacion_ReservaDTO))
            return false;
        Tipo_Habitacion_ReservaDTO other = (Tipo_Habitacion_ReservaDTO) obj;
        if (id_reserva == null) {
            if (other.id_reserva != null)
                return false;
        } else if (!id_reserva.equals(other.id_reserva))
            return false;
        if (id_tipo_habitacion != other.id_tipo_habitacion)
            return false;
        return true;
    }
}
