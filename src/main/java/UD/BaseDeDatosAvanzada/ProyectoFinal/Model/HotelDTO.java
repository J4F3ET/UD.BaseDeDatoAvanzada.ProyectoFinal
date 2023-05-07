package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

@Entity
@Table(name = "hotel")
public class HotelDTO {
    @Id
    private long rnt_hotel;
    @Column
    private String nombre;
    @Column
    private String direccion;
    @Column
    private Date anio_inauguracion;
    @Column
    private float categoria;

    private int antiguedad;
    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<HabitacionDTO> habitaciones = new ArrayList<HabitacionDTO>();
    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Hotel_TelefonoDTO> telefonos = new ArrayList<Hotel_TelefonoDTO>();

    public HotelDTO() {
    }
    public HotelDTO(long rnt_hotel, String nombre, String direccion, Date anio_inauguracion, float categoria) {
        this.rnt_hotel = rnt_hotel;
        this.nombre = nombre;
        this.direccion = direccion;
        this.anio_inauguracion = anio_inauguracion;
        this.categoria = categoria;
        LocalDate fechaInauguracion = anio_inauguracion.toLocalDate();
        this.antiguedad = Period.between(fechaInauguracion, LocalDate.now()).getYears();

    }
    public long getRnt_hotel() {
        return rnt_hotel;
    }

    public void setRnt_hotel(long rnt_hotel) {
        this.rnt_hotel = rnt_hotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getAnio_inauguracion() {
        return anio_inauguracion;
    }

    public void setAnio_inauguracion(Date anio_inauguracion) {
        this.anio_inauguracion = anio_inauguracion;
    }

    public float getCategoria() {
        return categoria;
    }

    public void setCategoria(float categoria) {
        this.categoria = categoria;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public ArrayList<HabitacionDTO> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<HabitacionDTO> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public ArrayList<Hotel_TelefonoDTO> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList<Hotel_TelefonoDTO> telefonos) {
        this.telefonos = telefonos;
    }
}
