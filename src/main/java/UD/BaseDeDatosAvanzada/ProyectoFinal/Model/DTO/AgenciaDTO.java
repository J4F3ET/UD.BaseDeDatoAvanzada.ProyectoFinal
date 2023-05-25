package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;

/**
 * @Entity Indica que la clase es una entidad
 * @Table Indica la tabla que representa esta entidad en la base de datos
 * @Column Indica el nombre de la columna en la tabla
 * @EmbeddedId Indica que la clase es una clave primaria compuesta
 * @ManyToOne Indica la relación muchos a uno
 * @JoinColumn Indica el nombre de la columna que hace referencia a la clave primaria de la tabla referenciada
 * @OneToMany Indica la relación uno a muchos
 * @MappedBy Indica el nombre del atributo que hace referencia a la clave primaria de la tabla referenciada
 * @Fetch Indica el tipo de carga de datos
 * @Target Indica el tipo de clase que puede ser anotada con esta anotación
 * @Inherited Indica que la anotación puede ser heredada
 * Clase que representa la tabla Agencia de la base de datos
 */
@Entity
@Table(name = "agencia")
public class AgenciaDTO {
    @EmbeddedId
    private AgenciaPK id;
    @Column(length = 150)
    private String nombre_agencia;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = MunicipioDTO.class)
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    private MunicipioDTO municipio;

    @OneToMany(mappedBy = "agencia", fetch = FetchType.LAZY, targetEntity = ReservaDTO.class)
    @JsonManagedReference
    private ArrayList<ReservaDTO> reservas = new ArrayList<>();
    public AgenciaDTO() {
    }
    public AgenciaDTO(AgenciaPK id, String nombre_agencia, MunicipioDTO municipio) {
        this.id = id;
        this.nombre_agencia = nombre_agencia;
        this.municipio = municipio;
    }

    public AgenciaPK getId() {
        return id;
    }

    public void setId(AgenciaPK id) {
        this.id = id;
    }

    public String getNombre_agencia() {
        return nombre_agencia;
    }

    public void setNombre_agencia(String nombre_agencia) {
        this.nombre_agencia = nombre_agencia;
    }

    public MunicipioDTO getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipioDTO municipio) {
        this.municipio = municipio;
    }
}
