package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table
public class Hotel_TelefonoDTO {
    @Id
    private long telefono;
    @Id
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = HotelDTO.class)
    @JoinColumn(name = "rnt_hotel", referencedColumnName = "rnt_hotel")
    private HotelDTO hotelDTO;

    public Hotel_TelefonoDTO() {
    }
    public Hotel_TelefonoDTO(long telefono, long rnt_hotel) {
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
    public String toString() {
        return "Hotel_TelefonoDTO{" +
                "telefono=" + telefono +
                ", hotelDTO=" + hotelDTO +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel_TelefonoDTO)) return false;

        Hotel_TelefonoDTO that = (Hotel_TelefonoDTO) o;

        if (getTelefono() != that.getTelefono()) return false;
        return getHotelDTO() != null ? getHotelDTO().equals(that.getHotelDTO()) : that.getHotelDTO() == null;
    }
}
