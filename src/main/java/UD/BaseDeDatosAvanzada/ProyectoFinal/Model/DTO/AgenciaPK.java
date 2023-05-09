package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.*    ;
import java.io.Serializable;

@Embeddable
public class AgenciaPK implements Serializable {
    @Column(name = "rnt")
    private long rnt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private UsuarioDTO usuario;

    public AgenciaPK() {
    }
    public AgenciaPK(long rnt, UsuarioDTO usuario) {
        this.rnt = rnt;
        this.usuario = usuario;
    }

    public long getRnt() {
        return rnt;
    }

    public void setRnt(long rnt) {
        this.rnt = rnt;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
}
