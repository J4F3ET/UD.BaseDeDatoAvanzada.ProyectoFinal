package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
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
    private int id_reserva;
    @Column
    private Timestamp fecha_inicio;
    @Column
    private Timestamp fecha_final;
    @Column
    private double valor_total_pagar;
    @Column
    private double valor_min_pagar;
    @Column
    private short cant_personas;
    @Column
    private short cant_habitaciones;
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
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = HotelDTO.class)
    @JoinColumn(name = "rnt_hotel", referencedColumnName = "rnt_hotel")
    private HotelDTO hotel;
    @OneToMany(mappedBy = "id.id_reserva", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private ArrayList<Tipo_Habitacion_ReservaDTO> tipo_habitacion_reserva = new ArrayList<>();
    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private ArrayList<RegistroDTO> reserva_registros = new ArrayList<>();
    @OneToMany(mappedBy = "id.reservaDTO", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private ArrayList<UsarDTO> reserva_servicio = new ArrayList<>();
    public ReservaDTO() {
    }

    public ReservaDTO(int id_reserva,
                      Timestamp fecha_inicio,
                      Timestamp fecha_final,
                      double valor_total_pagar,
                      double valor_min_pagar,
                      short cant_personas,
                      short cant_habitaciones,
                      ResponsableDTO responsable,
                      AgenciaDTO agencia,
                      HotelDTO hotel
                       )
    {
        this.id_reserva = id_reserva;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.valor_total_pagar = valor_total_pagar;
        this.valor_min_pagar = valor_min_pagar;
        this.cant_personas = cant_personas;
        this.cant_habitaciones = cant_habitaciones;
        this.responsable = responsable;
        this.agencia = agencia;
        this.hotel = hotel;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
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

    public double getValor_total_pagar() {
        return valor_total_pagar;
    }

    public void setValor_total_pagar(double valor_total_pagar) {
        this.valor_total_pagar = valor_total_pagar;
    }

    public double getValor_min_pagar() {
        return valor_min_pagar;
    }

    public void setValor_min_pagar(double valor_min_pagar) {
        this.valor_min_pagar = valor_min_pagar;
    }

    public short getCant_personas() {
        return cant_personas;
    }

    public void setCant_personas(short cant_personas) {
        this.cant_personas = cant_personas;
    }

    public short getCant_habitaciones() {
        return cant_habitaciones;
    }

    public void setCant_habitaciones(short cant_habitaciones) {
        this.cant_habitaciones = cant_habitaciones;
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

    public HotelDTO getHotel() {
        return hotel;
    }

    public void setHotel(HotelDTO hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "ReservaDTO{" +
                "id_reserva=" + id_reserva +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_final=" + fecha_final +
                ", valor_total_pagar=" + valor_total_pagar +
                ", valor_min_pagar=" + valor_min_pagar +
                ", cant_personas=" + cant_personas +
                ", cant_habitaciones=" + cant_habitaciones +
                ", responsable=" + responsable +
                ", agencia=" + agencia +
                ", hotel=" + hotel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservaDTO that = (ReservaDTO) o;
        return id_reserva == that.id_reserva && Double.compare(that.valor_total_pagar, valor_total_pagar) == 0 &&
                Double.compare(that.valor_min_pagar, valor_min_pagar) == 0 && cant_personas == that.cant_personas &&
                cant_habitaciones == that.cant_habitaciones && Objects.equals(fecha_inicio, that.fecha_inicio) &&
                Objects.equals(fecha_final, that.fecha_final) && Objects.equals(responsable, that.responsable) &&
                Objects.equals(agencia, that.agencia) && Objects.equals(hotel, that.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id_reserva, fecha_inicio, fecha_final, valor_total_pagar,
                valor_min_pagar, cant_personas, cant_habitaciones,
                responsable, agencia, hotel);
    }
}
