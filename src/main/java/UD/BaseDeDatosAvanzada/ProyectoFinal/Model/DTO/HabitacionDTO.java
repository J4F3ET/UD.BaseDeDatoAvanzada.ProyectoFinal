package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;

import java.util.ArrayList;

/**
 * Clase que representa la tabla habitacion de la base de datos
 */
@Entity
@Table(name = "habitacion")
public class HabitacionDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero_habitacion;
    @Column
    private short max_huesped;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = HotelDTO.class)
    @JoinColumn(name = "rnt_hotel", referencedColumnName = "rnt_hotel")
    private HotelDTO hotelDTO;

    @OneToMany(mappedBy = "habitacion", fetch = FetchType.LAZY, targetEntity = RegistroDTO.class)
    private ArrayList<RegistroDTO> registros = new ArrayList<>();
    private double costo;

    public HabitacionDTO() {
    }
    public HabitacionDTO(int numero_habitacion, short max_huesped, HotelDTO hotelDTO) {
        this.numero_habitacion = numero_habitacion;
        this.max_huesped = max_huesped;
        this.hotelDTO = hotelDTO;
        this.costo = max_huesped * (hotelDTO.getCategoria()*50000);
    }

    public int getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(int numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public short getMax_huesped() {
        return max_huesped;
    }

    public void setMax_huesped(short max_huesped) {
        this.max_huesped = max_huesped;
    }

    public HotelDTO getHotelDTO() {
        return hotelDTO;
    }

    public void setHotelDTO(HotelDTO hotelDTO) {
        this.hotelDTO = hotelDTO;
    }

    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
}
