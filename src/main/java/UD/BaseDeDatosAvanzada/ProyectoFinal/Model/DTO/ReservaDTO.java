package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
/**
 * @Entity Clase que define los atributos para el objeto ReservaDTO.
 * @Table indica que la clase es una entidad y que se mapea a una tabla de base de datos
 * @Id indica que el atributo es una clave primaria
 * @GeneratedValue indica que el valor de la clave primaria es generado automáticamente
 * @Column indica el nombre de la columna en la tabla
 * @ManyToOne indica la relación muchos a uno
 * @OneToMany indica la relación uno a muchos
 * @JoinColumns indica el nombre de las columnas que hacen referencia a la clave primaria de la tabla padre
 * @JoinColumn indica el nombre de la columna que hace referencia a la clave primaria de la tabla padre
 * Clase que representa la tabla Reserva de la base de datos.
 */
@Entity
@Table(name = "reserva")
public class ReservaDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_reserva;
    @Column
    private Timestamp fecha_inicio;
    @Column
    private Timestamp fecha_final;
    @Column
    private Timestamp fecha_creacion;
    @Column
    private short cant_personas;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "identificacion", referencedColumnName = "identificacion"),
            @JoinColumn(name = "id_usuario_responsable", referencedColumnName = "id_usuario")
    })
    @JsonBackReference
    private ResponsableDTO responsable;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AgenciaDTO.class)
    @JoinColumns({
            @JoinColumn(name = "rnt_agencia", referencedColumnName = "rnt_agencia"),
            @JoinColumn(name = "id_usuario_agencia", referencedColumnName = "id_usuario")
    })
    @JsonBackReference
    private AgenciaDTO agencia;
    @OneToMany(mappedBy = "id.reserva", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Collection<RecibirDTO> habitacion = new ArrayList<>();

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Collection<RegistroDTO> reserva_registros = new ArrayList<>();
    @OneToMany(mappedBy = "id.reservaDTO", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Collection<UsarDTO> reserva_servicio = new ArrayList<>();
    public ReservaDTO() {
    }
    @OneToMany(mappedBy = "id.reservaDTO", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Collection<PagoDTO> pagos = new ArrayList<>();

    public ReservaDTO(long id_reserva, Timestamp fecha_inicio, Timestamp fecha_final, Timestamp fecha_creacion, short cant_personas, ResponsableDTO responsable, AgenciaDTO agencia, Collection<RecibirDTO> habitacion, Collection<RegistroDTO> reserva_registros, Collection<UsarDTO> reserva_servicio, Collection<PagoDTO> pagos) {
        this.id_reserva = id_reserva;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.fecha_creacion = fecha_creacion;
        this.cant_personas = cant_personas;
        this.responsable = responsable;
        this.agencia = agencia;
        this.habitacion = habitacion;
        this.reserva_registros = reserva_registros;
        this.reserva_servicio = reserva_servicio;
        this.pagos = pagos;
    }

    public long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Timestamp getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Timestamp fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Timestamp getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Timestamp fecha_final) {
        this.fecha_final = fecha_final;
    }

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public short getCant_personas() {
        return cant_personas;
    }

    public void setCant_personas(short cant_personas) {
        this.cant_personas = cant_personas;
    }

    public ResponsableDTO getResponsable() {
        return responsable;
    }

    public void setResponsable(ResponsableDTO responsable) {
        this.responsable = responsable;
    }

    public AgenciaDTO getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaDTO agencia) {
        this.agencia = agencia;
    }

    public Collection<RecibirDTO> getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Collection<RecibirDTO> habitacion) {
        this.habitacion = habitacion;
    }

    public Collection<RegistroDTO> getReserva_registros() {
        return reserva_registros;
    }

    public void setReserva_registros(Collection<RegistroDTO> reserva_registros) {
        this.reserva_registros = reserva_registros;
    }

    public Collection<UsarDTO> getReserva_servicio() {
        return reserva_servicio;
    }

    public void setReserva_servicio(Collection<UsarDTO> reserva_servicio) {
        this.reserva_servicio = reserva_servicio;
    }

    public Collection<PagoDTO> getPagos() {
        return pagos;
    }

    public void setPagos(Collection<PagoDTO> pagos) {
        this.pagos = pagos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservaDTO that = (ReservaDTO) o;
        return id_reserva == that.id_reserva && Objects.equals(that.fecha_creacion, fecha_creacion) && cant_personas == that.cant_personas && Objects.equals(fecha_inicio, that.fecha_inicio) && Objects.equals(fecha_final, that.fecha_final) && Objects.equals(responsable, that.responsable) && Objects.equals(agencia, that.agencia) && Objects.equals(habitacion, that.habitacion) && Objects.equals(reserva_registros, that.reserva_registros) && Objects.equals(reserva_servicio, that.reserva_servicio) && Objects.equals(pagos, that.pagos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_reserva, fecha_inicio, fecha_final, fecha_creacion, cant_personas, responsable, agencia, habitacion, reserva_registros, reserva_servicio, pagos);
    }

    @Override
    public String toString() {
        return """
                ReservaDTO{\
                id_reserva=\
                """ + id_reserva +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_final=" + fecha_final +
                ", fecha_creacion=" + fecha_creacion +
                ", cant_personas=" + cant_personas +
                ", responsable=" + responsable +
                ", agencia=" + agencia +
                ", habitacion=" + habitacion +
                ", reserva_registros=" + reserva_registros +
                ", reserva_servicio=" + reserva_servicio +
                ", pagos=" + pagos +
                '}';
    }
}
