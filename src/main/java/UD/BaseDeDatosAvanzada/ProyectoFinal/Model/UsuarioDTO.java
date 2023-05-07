package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "usuario")
public class UsuarioDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String correo;
    @Column
    private String contrasena;
    @Column
    private String alias;
    private String rol;
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Telefono_UsuarioDTO> telefonos = new ArrayList<Telefono_UsuarioDTO>();
    public UsuarioDTO() {
    }

    public UsuarioDTO(String nombre, String apellido, String correo, String contrasena, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public long getId_usuario() {
        return id_usuario;
    }


    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getCorreo() {
        return this.correo;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public String getRol() {
        return this.rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido= apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena= contrasena;
    }
    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getAlias() {
        return this.alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }

    public ArrayList<Telefono_UsuarioDTO> getTelefonos() {
        return telefonos;
    }
    public void setTelefonos(ArrayList<Telefono_UsuarioDTO> telefonos) {
        this.telefonos = telefonos;
    }
    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id_usuario=" + id_usuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", alias='" + alias + '\'' +
                ", rol='" + rol + '\'' +
                '}';
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
