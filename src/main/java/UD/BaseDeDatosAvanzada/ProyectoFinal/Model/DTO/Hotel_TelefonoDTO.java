package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;
/**
 * Clse que define los atributos para el objeto Hotel_TelefonoDTO.
 */
@Entity
@Table(name = "hotel_telefono")
public class Hotel_TelefonoDTO {
    @EmbeddedId
    private Hotel_TelefonoPK hotel_telefonoPK;

    public Hotel_TelefonoDTO(Hotel_TelefonoPK hotel_telefonoPK) {
        this.hotel_telefonoPK = hotel_telefonoPK;
    }

    public Hotel_TelefonoDTO() {
    }

    public Hotel_TelefonoPK getHotel_telefonoPK() {
        return hotel_telefonoPK;
    }

    public void setHotel_telefonoPK(Hotel_TelefonoPK id) {
        this.hotel_telefonoPK = id;
    }
}
