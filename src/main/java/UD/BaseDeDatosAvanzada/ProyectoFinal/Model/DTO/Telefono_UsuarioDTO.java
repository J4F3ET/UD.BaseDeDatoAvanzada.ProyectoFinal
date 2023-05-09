package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;
/**
 * Clase que define los atributos para el objeto Telefono_UsuarioDTO.
 */
@Entity
@Table(name = "telefono_usuario")
public class Telefono_UsuarioDTO {
    @EmbeddedId
    private Telefono_UsuarioPK telefono_usuarioPK;
    public Telefono_UsuarioDTO() {
    }
    public Telefono_UsuarioDTO(Telefono_UsuarioPK telefono_usuarioPK) {
        this.telefono_usuarioPK = telefono_usuarioPK;
    }

    public Telefono_UsuarioPK getId() {
        return telefono_usuarioPK;
    }

    public void setId(Telefono_UsuarioPK telefono_usuarioPK) {
        this.telefono_usuarioPK = telefono_usuarioPK;
    }
}
