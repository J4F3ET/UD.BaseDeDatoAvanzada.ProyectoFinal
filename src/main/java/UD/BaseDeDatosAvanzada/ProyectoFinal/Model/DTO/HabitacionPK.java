package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
/**
 * @Embeddable es una anotación que se utiliza para definir una clase cuyos atributos representan los campos de una clave primaria compuesta.
 * @Column indica que el atributo es un campo de la tabla
 * @ManyToOne indica la relación muchos a uno
 * @JoinColumn indica el nombre de la columna que hace referencia a la clave primaria de la tabla referenciada
 * Esta clase representa a la clave primaria de la tabla habitacion
 */
@Embeddable
public class HabitacionPK implements Serializable{
    private static final long serialVersionUID = 1L;
    @Column
    private short numero_habitacion;
    @Column
    private short piso;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rnt_hotel", referencedColumnName = "rnt_hotel")
    @JsonBackReference
    private HotelDTO hotelDTO;

    public HabitacionPK() {
    }

    public HabitacionPK(short numero_habitacion, short piso, HotelDTO hotelDTO) {
        this.numero_habitacion = numero_habitacion;
        this.piso = piso;
        this.hotelDTO = hotelDTO;
    }

    public short getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(short numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public short getPiso() {
        return piso;
    }

    public void setPiso(short piso) {
        this.piso = piso;
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
        HabitacionPK that = (HabitacionPK) o;
        return numero_habitacion == that.numero_habitacion && piso == that.piso && Objects.equals(hotelDTO, that.hotelDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero_habitacion, piso, hotelDTO);
    }

    @Override
    public String toString() {
        return "HabitacionPK{" +
                "numero_habitacion=" + numero_habitacion +
                ", piso=" + piso +
                ", hotelDTO=" + hotelDTO +
                '}';
    }
}
