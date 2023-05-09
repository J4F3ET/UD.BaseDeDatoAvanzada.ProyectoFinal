package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Hotel_TelefonoPK implements Serializable {
    @Column(name = "telefono")
    private long telefono;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = HotelDTO.class)
    @JoinColumn(name = "rnt_hotel", referencedColumnName = "rnt_hotel")
    private HotelDTO hotelDTO;

    public Hotel_TelefonoPK() {
    }
    public Hotel_TelefonoPK(long telefono, long rnt_hotel) {
        this.telefono = telefono;
    }
    public long getTelefono() {
        return telefono;
    }
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    public HotelDTO getHotelDTO() {
        return hotelDTO;
    }
    public void setHotelDTO(HotelDTO hotelDTO) {
        this.hotelDTO = hotelDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel_TelefonoPK that = (Hotel_TelefonoPK) o;
        return telefono == that.telefono && Objects.equals(hotelDTO, that.hotelDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefono, hotelDTO);
    }
}
