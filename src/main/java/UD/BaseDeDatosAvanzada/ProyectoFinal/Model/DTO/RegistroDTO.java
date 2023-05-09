package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "registro")
public class RegistroDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_registro;
    @Column
    private String nombre;
    @Column
    private int edad;
    @Column
    private Byte mascota;
    @Column
    private Date fecha;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = HabitacionDTO.class)
    @JoinColumn(name = "numero_habitacion", referencedColumnName = "numero_habitacion")
    private HabitacionDTO habitacion;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ReservaDTO.class)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    private ReservaDTO reserva;

    public RegistroDTO() {
    }
    public RegistroDTO(String nombre, int edad, Byte mascota, Date fecha, HabitacionDTO habitacion, ReservaDTO reserva) {
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

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Byte getMascota() {
        return mascota;
    }

    public void setMascota(Byte mascota) {
        this.mascota = mascota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
        return "RegistroDTO{" +
                "id_registro=" + id_registro +
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
        if (obj instanceof RegistroDTO) {
            RegistroDTO tmpObj = (RegistroDTO) obj;
            if (this.id_registro == tmpObj.getId_registro()) {
                return true;
            }
        }
        return false;
    }

}
