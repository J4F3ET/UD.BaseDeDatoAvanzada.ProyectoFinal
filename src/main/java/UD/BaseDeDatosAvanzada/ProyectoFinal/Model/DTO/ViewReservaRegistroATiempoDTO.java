package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Subselect;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "viewReservasRegistradasATiempo")
@Subselect("SELECT r.* FROM reserva r INNER JOIN registro re USING(id_reserva) WHERE (EXTRACT(HOUR FROM re.fecha) BETWEEN 15 AND 19)  AND DATE(re.fecha) = r.fecha_inicio;")
public class ViewReservaRegistroATiempoDTO {
    @Id
    private long id_reserva;
    @Column
    private short cant_personas;
    @Column
    private Timestamp fecha_creacion;
    @Column
    private Timestamp fecha_final;
    @Column
    private Timestamp fecha_inicio;
    @Column
    private int rnt_agencia;
    @Column
    private long id_usuario_agencia;
    @Column
    private long identificacion;
    @Column
    private long id_usuario_responsable;

    public ViewReservaRegistroATiempoDTO() {
    }

    public long getId_reserva() {
        return id_reserva;
    }

    public short getCant_personas() {
        return cant_personas;
    }

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public Timestamp getFecha_final() {
        return fecha_final;
    }

    public Timestamp getFecha_inicio() {
        return fecha_inicio;
    }

    public int getRnt_agencia() {
        return rnt_agencia;
    }

    public long getId_usuario_agencia() {
        return id_usuario_agencia;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public long getId_usuario_responsable() {
        return id_usuario_responsable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewReservaRegistroATiempoDTO that = (ViewReservaRegistroATiempoDTO) o;
        return id_reserva == that.id_reserva && cant_personas == that.cant_personas && rnt_agencia == that.rnt_agencia && id_usuario_agencia == that.id_usuario_agencia && identificacion == that.identificacion && id_usuario_responsable == that.id_usuario_responsable && Objects.equals(fecha_creacion, that.fecha_creacion) && Objects.equals(fecha_final, that.fecha_final) && Objects.equals(fecha_inicio, that.fecha_inicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_reserva, cant_personas, fecha_creacion, fecha_final, fecha_inicio, rnt_agencia, id_usuario_agencia, identificacion, id_usuario_responsable);
    }

    @Override
    public String toString() {
        return "ViewReservaRegistroATiempoDTO{" +
                "id_reserva=" + id_reserva +
                ", cant_personas=" + cant_personas +
                ", fecha_creacion=" + fecha_creacion +
                ", fecha_final=" + fecha_final +
                ", fecha_inicio=" + fecha_inicio +
                ", rnt_agencia=" + rnt_agencia +
                ", id_usuario_agencia=" + id_usuario_agencia +
                ", identificacion=" + identificacion +
                ", id_usuario_responsable=" + id_usuario_responsable +
                '}';
    }
}
