package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "pago")
public class PagoDTO {
    @EmbeddedId
    private PagoPK id;
    @Column(name = "pago_total")
    private int pagototal;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "valor")
    private int valor;

    public PagoDTO() {
    }

    public PagoDTO(PagoPK id, int pagototal, Date fecha, int valor) {
        this.id = id;
        this.pagototal = pagototal;
        this.fecha = fecha;
        this.valor = valor;
    }

    public PagoPK getId() {
        return id;
    }

    public void setId(PagoPK id) {
        this.id = id;
    }

    public int getPagototal() {
        return pagototal;
    }

    public void setPagototal(int pagototal) {
        this.pagototal = pagototal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagoDTO pagoDTO = (PagoDTO) o;
        return pagototal == pagoDTO.pagototal && valor == pagoDTO.valor && Objects.equals(id, pagoDTO.id) && Objects.equals(fecha, pagoDTO.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pagototal, fecha, valor);
    }

    @Override
    public String toString() {
        return "PagoDTO{" +
                "id=" + id +
                ", pagototal=" + pagototal +
                ", fecha=" + fecha +
                ", valor=" + valor +
                '}';
    }
}
