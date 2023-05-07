package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "telefono_usuario")
public class Telefono_UsuarioDTO {
    @Id
    @Column
    private long telefono;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
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
}
