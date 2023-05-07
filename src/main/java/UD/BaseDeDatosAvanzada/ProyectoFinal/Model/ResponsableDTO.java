package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "responsable")
public class ResponsableDTO {
    @Id
    @Column
    private long identificacion;
    @Id
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = UsuarioDTO.class)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private UsuarioDTO usuario;

    public ResponsableDTO() {
    }
    public ResponsableDTO(long identificacion, long id_usuario) {
        this.identificacion = identificacion;
    }
    public long getIdentificacion() {
        return identificacion;
    }
    public UsuarioDTO getUsuario() {
        return usuario;
    }
    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }
    @Override
    public String toString() {
        return "ResponsableDTO [identificacion=" + identificacion + ", usuario=" + usuario + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ResponsableDTO))
            return false;
        ResponsableDTO other = (ResponsableDTO) obj;
        if (identificacion != other.identificacion)
            return false;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        return true;
    }
}
