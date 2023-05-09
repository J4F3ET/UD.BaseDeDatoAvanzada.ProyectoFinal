package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;

@Entity
@Table(name = "telefono_usuario")
public class Telefono_UsuarioDTO {
    @EmbeddedId
    private Telefono_UsuarioPK id;
    public Telefono_UsuarioDTO() {
    }
    public Telefono_UsuarioDTO(Telefono_UsuarioPK id) {
        this.id = id;
    }

    public Telefono_UsuarioPK getId() {
        return id;
    }

    public void setId(Telefono_UsuarioPK id) {
        this.id = id;
    }
}
