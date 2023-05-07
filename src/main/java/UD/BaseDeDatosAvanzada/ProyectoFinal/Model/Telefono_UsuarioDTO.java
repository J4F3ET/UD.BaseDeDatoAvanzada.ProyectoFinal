package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "telefono_usuario")
public class Telefono_UsuarioDTO {
    @Id
    private long telefono;
    @Id
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = UsuarioDTO.class)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private UsuarioDTO usuario;
    public Telefono_UsuarioDTO() {
    }
    public Telefono_UsuarioDTO(long telefono, long id_usuario) {
        this.telefono = telefono;

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
}
