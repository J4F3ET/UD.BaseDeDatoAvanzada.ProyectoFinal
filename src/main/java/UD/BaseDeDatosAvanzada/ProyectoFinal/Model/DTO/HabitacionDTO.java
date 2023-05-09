package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;

@Entity
@Table(name = "habitacion")
public class HabitacionDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numero_habitacion;
    @Column
    private int max_huesped;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = HotelDTO.class)
    @JoinColumn(name = "rnt_hotel", referencedColumnName = "rnt_hotel")
    private HotelDTO hotelDTO;
    private double costo;

    public HabitacionDTO() {
    }
    public HabitacionDTO(long numero_habitacion, int max_huesped, HotelDTO hotelDTO) {
        this.numero_habitacion = numero_habitacion;
        this.max_huesped = max_huesped;
        this.hotelDTO = hotelDTO;
        this.costo = max_huesped * (hotelDTO.getCategoria()*50000);
    }

    public long getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(long numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public int getMax_huesped() {
        return max_huesped;
    }

    public void setMax_huesped(int max_huesped) {
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
