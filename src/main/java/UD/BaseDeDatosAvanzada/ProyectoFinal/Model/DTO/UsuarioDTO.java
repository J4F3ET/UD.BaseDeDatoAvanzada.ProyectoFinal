    package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

    import jakarta.persistence.*;
    import java.util.Collection;
    import java.util.ArrayList;
    @Entity
    @Table(name = "usuario")
    public class UsuarioDTO {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "usuario_id_usuario_seq")
        @SequenceGenerator(name = "usuario_id_usuario_seq", sequenceName = "usuario_id_usuario_seq", allocationSize = 1)
        @Column(name = "id_usuario")
        private long id;
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
        @OneToMany(mappedBy = "telefono_usuarioPK.usuario", cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonIgnore
        private Collection<Telefono_UsuarioDTO> telefonos;

        public UsuarioDTO() {
        }

        public UsuarioDTO(String nombre, String correo, String password, String alias, String direccion) {
            this.nombre = nombre;
            this.correo = correo;
            this.password = password;
            this.alias = alias;
            this.direccion = direccion;
        }

        public long getId_usuario() {
            return id;
        }

        public void setId_usuario(long id_usuario) {
            this.id = id_usuario;
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

        public Collection<Telefono_UsuarioDTO> getTelefonos() {
            return telefonos;
        }

        public void setTelefonos(ArrayList<Telefono_UsuarioDTO> telefonos) {
            this.telefonos = telefonos;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof UsuarioDTO tmpPersona) {
                if (this.id == tmpPersona.id) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return """
                    UsuarioDTO{\
                    id=\
                    """ + id +
                    ", nombre='" + nombre + '\'' +
                    ", correo='" + correo + '\'' +
                    ", password='" + password + '\'' +
                    ", alias='" + alias + '\'' +
                    ", direccion='" + direccion + '\'' +
                    '}';
        }
    }
