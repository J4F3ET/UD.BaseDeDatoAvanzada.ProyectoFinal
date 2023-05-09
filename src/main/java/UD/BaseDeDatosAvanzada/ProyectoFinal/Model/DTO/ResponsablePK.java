package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
public class ResponsablePK implements Serializable {
    @Column(name = "identificacion")
    private long identificacion;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = UsuarioDTO.class)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private UsuarioDTO usuario;

    public ResponsablePK() {
    }

    public ResponsablePK(long identificacion, UsuarioDTO usuario) {
        this.identificacion = identificacion;
        this.usuario = usuario;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
}
