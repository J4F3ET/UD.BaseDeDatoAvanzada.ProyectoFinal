package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO;

import jakarta.persistence.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono_UsuarioDTO that = (Telefono_UsuarioDTO) o;
        return Objects.equals(telefono_usuarioPK, that.telefono_usuarioPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefono_usuarioPK);
    }

    @Override
    public String toString() {
        String response = "Telefono_UsuarioDTO{";
        if(telefono_usuarioPK != null){
            response.concat("telefono_usuarioPK=" + telefono_usuarioPK.toString());
        }else{
            response.concat("telefono_usuarioPK=null");
        }
        response.concat("}");
        return  response;
    }
}
