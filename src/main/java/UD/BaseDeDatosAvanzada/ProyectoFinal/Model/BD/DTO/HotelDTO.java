package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "hotel")
public class HotelDTO{
    @Id
    @Column(name = "rnt_hotel")
    private int id;
    @Column(length = 150)
    private String nombre;
    @Column(length = 150)
    private String direccion;
    @Column
    private short anio_inauguracion;
    @Column
    private float categoria;
    @Column
    private Timestamp fecha_actualizacion;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = MunicipioDTO.class)
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    @JsonBackReference
    private MunicipioDTO municipio;
    @OneToMany(mappedBy = "hotel_telefonoPK.hotelDTO",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Collection<Hotel_TelefonoDTO> telefonos = new ArrayList<Hotel_TelefonoDTO>();
    @OneToMany(mappedBy = "habitacionPK.hotelDTO",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Collection<HabitacionDTO> habitaciones = new ArrayList<>();
    @Transient
    private LocalDate currentDate = LocalDate.now();
    @Transient
    private int antiguedad = currentDate.getYear() - anio_inauguracion;
    public HotelDTO() {
    }

    public HotelDTO(int rnt_hotel, String nombre, String direccion, short anio_inauguracion, float categoria, Timestamp fecha_actualizacion, Collection<Hotel_TelefonoDTO> telefonos, Collection<HabitacionDTO> habitaciones, int antiguedad) {
        this.id = rnt_hotel;
        this.nombre = nombre;
        this.direccion = direccion;
        this.anio_inauguracion = anio_inauguracion;
        this.fecha_actualizacion = fecha_actualizacion;
        this.telefonos = telefonos;
        this.habitaciones = habitaciones;
        this.antiguedad = currentDate.getYear() - anio_inauguracion;
    }

    @Override
    public String toString() {
        return """
                HotelDTO{\
                rnt_hotel=\
                """ + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", anio_inauguracion=" + anio_inauguracion +
                ", categoria=" + categoria +
                ", fecha_actualizacion=" + fecha_actualizacion +
                ", telefonos=" + telefonos +
                ", habitaciones=" + habitaciones +
                ", antiguedad=" + antiguedad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelDTO hotelDTO = (HotelDTO) o;
        return id == hotelDTO.id && anio_inauguracion == hotelDTO.anio_inauguracion && Float.compare(hotelDTO.categoria, categoria) == 0 && antiguedad == hotelDTO.antiguedad && Objects.equals(nombre, hotelDTO.nombre) && Objects.equals(direccion, hotelDTO.direccion) && Objects.equals(fecha_actualizacion, hotelDTO.fecha_actualizacion) && Objects.equals(telefonos, hotelDTO.telefonos) && Objects.equals(habitaciones, hotelDTO.habitaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, direccion, anio_inauguracion, categoria, fecha_actualizacion, telefonos, habitaciones, antiguedad);
    }

    public int getId() {
        return id;
    }

    public void setRnt_hotel(int rnt_hotel) {
        this.id = rnt_hotel;
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

    public Timestamp getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Timestamp fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public Collection<Hotel_TelefonoDTO> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Collection<Hotel_TelefonoDTO> telefonos) {
        this.telefonos = telefonos;
    }

    public Collection<HabitacionDTO> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Collection<HabitacionDTO> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}
