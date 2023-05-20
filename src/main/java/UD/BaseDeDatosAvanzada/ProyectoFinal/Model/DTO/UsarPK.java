package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
/**
 * @Entity Clase que define los atributos para el objeto UsarDTO.
 * @Table indica que la clase es una entidad y que se mapea a una tabla de base de datos
 * @EmbeddedId indica que la clase es una clave primaria compuesta
 * @ManyToOne indica que la clase es una clave foranea
 * @JoinColumn indica el nombre de la columna de la clave foranea
 * Clase que representa la llave primaria de la tabla usar de la base de datos.
 */
@Embeddable
public class UsarPK implements Serializable{
    private static final long serialVersionUID = 1L;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ServicioDTO.class)
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    private ServicioDTO servicioDTO;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ReservaDTO.class)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    private ReservaDTO reservaDTO;

    public UsarPK() {
    }
    public UsarPK(ServicioDTO servicioDTO, ReservaDTO reservaDTO) {
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
        return "UsarPK{" +
                "servicioDTO=" + servicioDTO +
                ", reservaDTO=" + reservaDTO +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsarPK usarPK = (UsarPK) o;
        return Objects.equals(servicioDTO, usarPK.servicioDTO) && Objects.equals(reservaDTO, usarPK.reservaDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicioDTO, reservaDTO);
    }
}
