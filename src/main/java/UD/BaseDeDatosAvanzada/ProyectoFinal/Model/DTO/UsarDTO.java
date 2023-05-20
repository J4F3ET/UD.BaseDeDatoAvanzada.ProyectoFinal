package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;

import java.util.Objects;
/**
 * @Entity Clase que define los atributos para el objeto UsarDTO.
 * @Table indica que la clase es una entidad y que se mapea a una tabla de base de datos
 * @EmbeddedId indica que la clase es una clave primaria compuesta
 * Clase que representa la tabla usar de la base de datos..
 */
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
