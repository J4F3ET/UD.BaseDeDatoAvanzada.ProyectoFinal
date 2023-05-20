package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
/**
 * @Entity Indica que la clase es una entidad
 * @Table Indica la tabla que representa esta entidad en la base de datos
 * @Column Indica el nombre de la columna en la tabla
 * @Id Indica que el atributo es una clave primaria
 * @ManyToOne Indica la relación muchos a uno
 * @JoinColumn Indica el nombre de la columna que hace referencia a la clave primaria de la tabla referenciada
 * @OneToMany Indica la relación uno a muchos
 * @MappedBy Indica el nombre del atributo que hace referencia a la clave primaria de la tabla referenciada
 * @Fetch Indica el tipo de carga de datos
 * @Inherited Indica que la anotación puede ser heredada
 * Clase que representa la tabla Hotel de la base de datos.
 */
@Entity
@Table(name = "hotel")
public class HotelDTO {
    @Id
    private int rnt_hotel;
    @Column(length = 150)
    private String nombre;
    @Column(length = 150)
    private String direccion;
    @Column
    private short anio_inauguracion;
    @Column
    private float categoria;
    @OneToMany(mappedBy = "hotel_telefonoPK.hotelDTO",cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Hotel_TelefonoDTO> telefonos = new ArrayList<Hotel_TelefonoDTO>();
    @OneToMany(mappedBy = "habitacionPK.hotelDTO",cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<HabitacionDTO> habitaciones = new ArrayList<>();
    @Transient
    private int antiguedad;
    public HotelDTO() {
    }
    public HotelDTO(int rnt_hotel, String nombre, String direccion, short anio_inauguracion, float categoria) {
        this.rnt_hotel = rnt_hotel;
        this.nombre = nombre;
        this.direccion = direccion;
        this.anio_inauguracion = anio_inauguracion;
        this.categoria = categoria;
        this.antiguedad = anio_inauguracion - (LocalDate.now().getYear());

    }
    public long getRnt_hotel() {
        return rnt_hotel;
    }

    public void setRnt_hotel(int rnt_hotel) {
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

    public short getAnio_inauguracion() {
        return anio_inauguracion;
    }

    public void setAnio_inauguracion(short anio_inauguracion) {
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
