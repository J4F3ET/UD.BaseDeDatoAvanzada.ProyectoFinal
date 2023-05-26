package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Collection;
import java.util.ArrayList;
/**
 * @Entity Clase que define los atributos para el objeto UsuarioDTO.
 * @Table indica que la clase es una entidad y que se mapea a una tabla de base de datos
 * @Id indica que el atributo es una clave primaria
 * @GeneratedValue indica que el atributo es autogenerado
 * @OneToMany indica que la clase es una relación uno a muchos
 * @Column indica el nombre de la columna en la tabla
 * @JsonManagedReference indica que la clase es una relación uno a muchos, y que es la clase padre, por lo que se serializa
 * y se deserializa normalmente y la clase hija se serializa y deserializa como un id. Tambien se usa para evitar errores
 * de recursividad.
 * Clase que representa la tabla Usuario de la base de datos.
 */
@Entity
@Table(name = "usuario")
public class UsuarioDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JsonManagedReference
    private Collection<Telefono_UsuarioDTO> telefonos = new ArrayList<>();
    public UsuarioDTO() {
    }

    public UsuarioDTO(long id_usuario, String nombre, String correo, String password, String alias, String direccion, ArrayList<Telefono_UsuarioDTO> telefonos) {
        this.id = id_usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.alias = alias;
        this.direccion = direccion;
        this.telefonos = telefonos;
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
        if (obj instanceof UsuarioDTO) {
            UsuarioDTO tmpPersona = (UsuarioDTO) obj;
            if (this.id == tmpPersona.id) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
