package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class PagoPK implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ReservaDTO.class)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    @JsonBackReference
    private ReservaDTO reservaDTO;

    public PagoPK() {
    }
    public PagoPK(short id, ReservaDTO reservaDTO) {
        this.id = id;
        this.reservaDTO = reservaDTO;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public ReservaDTO getReservaDTO() {
        return reservaDTO;
    }

    public void setReservaDTO(ReservaDTO reservaDTO) {
        this.reservaDTO = reservaDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagoPK pagoPK = (PagoPK) o;
        return id == pagoPK.id && Objects.equals(reservaDTO, pagoPK.reservaDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reservaDTO);
    }

    @Override
    public String toString() {
        return """
                PagoPK{\
                id=\
                """ + id +
                ", reservaDTO=" + reservaDTO +
                '}';
    }
}
