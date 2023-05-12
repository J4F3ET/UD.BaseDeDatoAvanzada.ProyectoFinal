package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*    ;
import java.io.Serializable;
import java.util.Objects;
/**
 * Clase que representa a la clave primaria de la tabla agencia
 */
@Embeddable
public class AgenciaPK implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "rnt_agencia")
    private int rnt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private UsuarioDTO usuario;

    public AgenciaPK() {
    }
    public AgenciaPK(int rnt, UsuarioDTO usuario) {
        this.rnt = rnt;
        this.usuario = usuario;
    }

    public int getRnt() {
        return rnt;
    }

    public void setRnt(int rnt) {
        this.rnt = rnt;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgenciaPK agenciaPK = (AgenciaPK) o;
        return rnt == agenciaPK.rnt && Objects.equals(usuario, agenciaPK.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rnt, usuario);
    }
}
