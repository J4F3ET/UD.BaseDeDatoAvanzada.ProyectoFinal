package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;
import java.util.ArrayList;
/**
 * Clase que representa la tabla Usuario de la base de datos.
 */
@Entity
@Table(name = "usuario")
public class UsuarioDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;
    @Column(length = 50)
    private String nombre;
    @Column(name = "correo_electronico",length = 50)
    private String correo;
    @Column(length = 50)
    private String password;
    @Column(length = 50)
    private String alias;
    @Column(length = 100)
    private String direccion;
    @OneToMany(mappedBy = "telefono_usuarioPK.usuario",cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Telefono_UsuarioDTO> telefonos = new ArrayList<>();
    public UsuarioDTO() {
    }

    public UsuarioDTO(long id_usuario, String nombre, String correo, String password, String alias, String direccion, ArrayList<Telefono_UsuarioDTO> telefonos) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.alias = alias;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Telefono_UsuarioDTO> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList<Telefono_UsuarioDTO> telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UsuarioDTO) {
            UsuarioDTO tmpPersona = (UsuarioDTO) obj;
            if (this.id_usuario == tmpPersona.id_usuario) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
