package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table(name= "usar")
public class UsarDTO {
    @Id
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ServicioDTO.class)
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    private ServicioDTO servicioDTO;
    @Id
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ReservaDTO.class)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    private ReservaDTO reservaDTO;

    public UsarDTO() {
    }
    public UsarDTO(ServicioDTO servicioDTO, ReservaDTO reservaDTO) {
        this.servicioDTO = servicioDTO;
        this.reservaDTO = reservaDTO;
    }

    public ServicioDTO getServicioDTO() {
        return servicioDTO;
    }

    public void setServicioDTO(ServicioDTO servicioDTO) {
        this.servicioDTO = servicioDTO;
    }

    public ReservaDTO getReservaDTO() {
        return reservaDTO;
    }

    public void setReservaDTO(ReservaDTO reservaDTO) {
        this.reservaDTO = reservaDTO;
    }
    @Override
    public String toString() {
        return "UsarDTO [reservaDTO=" + reservaDTO + ", servicioDTO=" + servicioDTO + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof UsarDTO))
            return false;
        UsarDTO other = (UsarDTO) obj;
        if (reservaDTO == null) {
            if (other.reservaDTO != null)
                return false;
        } else if (!reservaDTO.equals(other.reservaDTO))
            return false;
        if (servicioDTO == null) {
            if (other.servicioDTO != null)
                return false;
        } else if (!servicioDTO.equals(other.servicioDTO))
            return false;
        return true;
    }
}
