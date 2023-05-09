package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name= "usar")
public class UsarDTO {
    @EmbeddedId
    private UsarPK id;
    public UsarDTO() {
    }
    public UsarDTO(UsarPK id) {
        this.id = id;
    }

    public UsarPK getId() {
        return id;
    }

    public void setId(UsarPK id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UsarDTO{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsarDTO usarDTO = (UsarDTO) o;
        return Objects.equals(id, usarDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
