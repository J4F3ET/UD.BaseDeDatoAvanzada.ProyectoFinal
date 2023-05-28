package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;
/**
 * @Embeddable Clase que define los atributos para el objeto ResponsablePK.
 * @Column indica que el atributo es un campo de la tabla
 * @ManyToOne indica la relación muchos a uno
 * @JoinColumn indica el nombre de la columna que hace referencia a la clave primaria de la tabla referenciada
 * Clase que representa la llave primaria de la tabla Responsable de la base de datos.
 */
@Embeddable
public class ResponsablePK implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "identificacion")
    private long identificacion;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = UsuarioDTO.class)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @JsonBackReference
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponsablePK that = (ResponsablePK) o;
        return identificacion == that.identificacion && Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificacion, usuario);
    }

    @Override
    public String toString() {
        return "ResponsablePK{" +
                "identificacion=" + identificacion +
                ", usuario=" + usuario +
                '}';
    }
}
