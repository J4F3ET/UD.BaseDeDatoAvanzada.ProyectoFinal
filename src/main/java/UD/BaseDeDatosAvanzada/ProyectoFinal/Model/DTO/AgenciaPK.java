package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*    ;
import java.io.Serializable;
import java.util.Objects;
/**
 * @Embeddable indica que la clase puede ser usada como una clave primaria compuesta
 * @Column indica que el atributo es un campo de la tabla
 * @ManyToOne indica la relación muchos a uno
 * @JoinColumn indica el nombre de la columna que hace referencia a la clave primaria de la tabla referenciada
 * @Target indica el tipo de clase que puede ser anotada con esta anotación
 * @Inherited indica que la anotación puede ser heredada
 * Clase que representa a la clave primaria de la tabla agencia
 */
@Embeddable
public class AgenciaPK implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "rnt_agencia")
    private int rnt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @JsonBackReference
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
