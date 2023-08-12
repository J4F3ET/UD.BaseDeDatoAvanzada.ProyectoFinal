package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.sql.Timestamp;

/**
 * @Entity Indica que la clase es una entidad
 * @Table indica que la clase es una entidad y que se mapea a una tabla de base de datos
 * @Id indica que el atributo es una clave primaria
 * @GeneratedValue indica que el valor de la clave primaria es generado automáticamente
 * @Column indica el nombre de la columna en la tabla
 * @ManyToOne indica la relación muchos a uno
 * @JoinColumns indica la relación entre las tablas
 * @JoinColumn indica la columna que hace referencia a la clave primaria de la tabla relacionada
 * @Temporal indica el formato de la fecha
 * Clase que representa los atributos la tabla RegistroDTO de la base de datos.
 */
@Entity
@Table(name = "registro")
public class RegistroDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_registro;
    @Column(length = 50)
    private String nombre;
    @Column
    private short edad;
    @Column
    private boolean mascota;
    @Column
    private Timestamp fecha;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = HabitacionDTO.class)
    @JsonBackReference
    @JoinColumns({
                    @JoinColumn(name = "piso", referencedColumnName = "piso"),
                    @JoinColumn(name = "numero_habitacion", referencedColumnName = "numero_habitacion"),
                    @JoinColumn(name = "rnt_hotel", referencedColumnName = "rnt_hotel")
            })
    private HabitacionDTO habitacion;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ReservaDTO.class)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    @JsonBackReference
    private ReservaDTO reserva;

    public RegistroDTO() {
    }
    public RegistroDTO(String nombre, short edad, boolean mascota, Timestamp fecha, HabitacionDTO habitacion, ReservaDTO reserva) {
        this.nombre = nombre;
        this.edad = edad;
        this.mascota = mascota;
        this.fecha = fecha;
        this.habitacion = habitacion;
        this.reserva = reserva;
    }

    public long getId_registro() {
        return id_registro;
    }

    public void setId_registro(long id_registro) {
        this.id_registro = id_registro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public boolean getMascota() {
        return mascota;
    }

    public void setMascota(boolean mascota) {
        this.mascota = mascota;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public HabitacionDTO getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(HabitacionDTO habitacion) {
        this.habitacion = habitacion;
    }

    public ReservaDTO getReserva() {
        return reserva;
    }

    public void setReserva(ReservaDTO reserva) {
        this.reserva = reserva;
    }
    @Override
    public String toString() {
        return """
                RegistroDTO{\
                id_registro=\
                """ + id_registro +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", mascota=" + mascota +
                ", fecha=" + fecha +
                ", habitacion=" + habitacion +
                ", reserva=" + reserva +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RegistroDTO tmpObj) {
            if (this.id_registro == tmpObj.getId_registro()) {
                return true;
            }
        }
        return false;
    }

}
