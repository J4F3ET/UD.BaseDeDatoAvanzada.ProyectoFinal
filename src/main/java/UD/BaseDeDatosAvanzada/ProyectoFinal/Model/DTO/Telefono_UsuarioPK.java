package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Telefono_UsuarioPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = UsuarioDTO.class)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @JsonIgnoreProperties("telefonos")
    private UsuarioDTO usuario;

    @Column(name = "telefono")
    private long telefono;
    public Telefono_UsuarioPK() {
    }
    public Telefono_UsuarioPK(long telefono, UsuarioDTO usuario) {
        this.telefono = telefono;
        this.usuario = usuario;
    }
    public long getTelefono() {
        return this.telefono;
    }
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    public UsuarioDTO getUsuario() {
        return this.usuario;
    }
    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono_UsuarioPK that = (Telefono_UsuarioPK) o;
        return telefono == that.telefono && Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefono, usuario);
    }

    @Override
    public String toString() {
        return """
                Telefono_UsuarioPK{\
                telefono=\
                """ + telefono +
                ", usuario=" + usuario +
                '}';
    }
}
