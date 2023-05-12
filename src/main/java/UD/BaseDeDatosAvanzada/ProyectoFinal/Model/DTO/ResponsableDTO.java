package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;

import java.util.ArrayList;

/**
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
