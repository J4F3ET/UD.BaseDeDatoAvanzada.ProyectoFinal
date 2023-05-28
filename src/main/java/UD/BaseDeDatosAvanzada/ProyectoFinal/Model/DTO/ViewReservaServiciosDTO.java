package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.hibernate.annotations.Subselect;

import java.sql.Timestamp;
import java.util.Objects;

@Subselect("SELECT r.id_reserva,s.nombre FROM reserva r INNER JOIN usar u ON(r.id_reserva=u.id_reserva) INNER JOIN servicio s USING(id_servicio);")
public class ViewReservaServiciosDTO {
    @Id
    private long id_reserva;
    @Id
    private int id_servicio;
    @Column
    private String nombre;
    @Column
    private double costo;
    public ViewReservaServiciosDTO() {
    }

    public long getId_reserva() {
        return id_reserva;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewReservaServiciosDTO that = (ViewReservaServiciosDTO) o;
        return id_reserva == that.id_reserva && id_servicio == that.id_servicio && Double.compare(that.costo, costo) == 0 && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_reserva, id_servicio, nombre, costo);
    }

    @Override
    public String toString() {
        return "ViewReservaServiciosDTO{" +
                "id_reserva=" + id_reserva +
                ", id_servicio=" + id_servicio +
                ", nombre='" + nombre + '\'' +
                ", costo=" + costo +
                '}';
    }
}
