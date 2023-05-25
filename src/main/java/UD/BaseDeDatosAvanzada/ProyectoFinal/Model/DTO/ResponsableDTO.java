package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;

/**
 * @Entity Clase que define los atributos para el objeto ResponsableDTO.
 * @Table indica que la clase es una entidad y que se mapea a una tabla de base de datos
 * @EmbeddedId indica que la clase es una clave primaria compuesta
 * @Column indica el nombre de la columna en la tabla
 * @OneToMany indica la relación uno a muchos
 * Clase que representa la tabla Responsable de la base de datos.
 */
@Entity
@Table(name = "responsable")
public class ResponsableDTO {
    @EmbeddedId
    private ResponsablePK id;
    @Column
    private short categoria;
    @OneToMany(mappedBy = "responsable", fetch = FetchType.LAZY, targetEntity = ReservaDTO.class)
    @JsonManagedReference
    private ArrayList<ReservaDTO> reservas = new ArrayList<>();
    public ResponsableDTO() {
    }
    public ResponsableDTO(ResponsablePK id, short categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public ResponsablePK getId() {
        return id;
    }

    public void setId(ResponsablePK id) {
        this.id = id;
    }

    public short getCategoria() {
        return categoria;
    }

    public void setCategoria(short categoria) {
        this.categoria = categoria;
    }

}
