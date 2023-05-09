package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "responsable")
public class ResponsableDTO {
    @EmbeddedId
    private ResponsablePK id;
    @Column
    private short categoria;
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
