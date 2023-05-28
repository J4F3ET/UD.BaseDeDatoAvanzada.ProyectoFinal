package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "recibir")
public class RecibirDTO {
    @EmbeddedId
    private RecibirPK id;

    public RecibirDTO() {
    }

    public RecibirDTO(RecibirPK id) {
        this.id = id;
    }

    public RecibirPK getId() {
        return id;
    }

    public void setId(RecibirPK id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecibirDTO that = (RecibirDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RecibirDTO{" +
                "id=" + id +
                '}';
    }
}
