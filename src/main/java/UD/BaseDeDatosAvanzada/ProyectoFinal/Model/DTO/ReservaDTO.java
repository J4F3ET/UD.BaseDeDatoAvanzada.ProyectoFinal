package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reserva")
public class ReservaDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_reserva;
    @Column
    private Date fecha_inicio;
    @Column
    private Date fecha_final;
    @Column
    private double valor_total_pagar;
    @Column
    private double valor_min_pagar;
    @Column
    private int cant_personas;
    @Column
    private int cant_habitaciones;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ResponsableDTO.class)
    @JoinColumns({
            @JoinColumn(name = "identificacion", referencedColumnName = "identificacion"),
            @JoinColumn(name = "id_usuario_responsable", referencedColumnName = "id_usuario")
    })
    private ResponsableDTO responsable;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AgenciaDTO.class)
    @JoinColumns({
            @JoinColumn(name = "rnt_agencia", referencedColumnName = "rnt_agencia"),
            @JoinColumn(name = "id_usuario_agencia", referencedColumnName = "id_usuario")
    })
    private AgenciaDTO agencia;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = HotelDTO.class)
    @JoinColumn(name = "rnt_hotel", referencedColumnName = "rnt_hotel")
    private HotelDTO hotel;

    public ReservaDTO() {
    }

    public ReservaDTO(long id_reserva,
                      Date fecha_inicio,
                      Date fecha_final,
                      double valor_total_pagar,
                      double valor_min_pagar,
                      int cant_personas,
                      int cant_habitaciones,
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

    public long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
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

    public int getCant_personas() {
        return cant_personas;
    }

    public void setCant_personas(int cant_personas) {
        this.cant_personas = cant_personas;
    }

    public int getCant_habitaciones() {
        return cant_habitaciones;
    }

    public void setCant_habitaciones(int cant_habitaciones) {
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
