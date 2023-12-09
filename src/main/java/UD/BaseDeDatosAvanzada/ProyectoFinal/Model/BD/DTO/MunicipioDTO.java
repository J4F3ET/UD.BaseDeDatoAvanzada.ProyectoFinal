package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Entity Clase que define los atributos para el objeto MunicipioDTO.
 * @Table indica que la clase es una entidad y que se mapea a una tabla de base de datos
 * @Id indica que el atributo es una clave primaria
 * @GeneratedValue indica que el valor de la clave primaria es generado automáticamente
 * @Column indica el nombre de la columna en la tabla
 * @OneToMany indica la relación uno a muchos
 * Clase que representa los atributos la tabla MunicipioDTO de la base de datos.
 */
@Entity
@Table(name = "municipio")
public class MunicipioDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_municipio;

    @Column(length = 50)
    private String nombre;

    @OneToMany(mappedBy = "municipio", fetch = FetchType.LAZY, targetEntity = AgenciaDTO.class)
    @JsonManagedReference
    private Collection<AgenciaDTO> agencias = new ArrayList<>();

    @OneToMany(mappedBy = "municipio", fetch = FetchType.LAZY, targetEntity = AgenciaDTO.class)
    @JsonManagedReference
    private Collection<HotelDTO> hoteles = new ArrayList<>();

    public MunicipioDTO() {
    }
    public MunicipioDTO(short id_municipio, String nombre) {
        this.id_municipio = id_municipio;
        this.nombre = nombre;
    }
    public int getId_municipio() {
        return id_municipio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Collection<AgenciaDTO> getAgencias() {
        return agencias;
    }
    public void setAgencias(Collection<AgenciaDTO> agencias) {
        this.agencias = agencias;
    }
    public Collection<HotelDTO> getHoteles() {
        return hoteles;
    }
    public void setHoteles(Collection<HotelDTO> hoteles) {
        this.hoteles = hoteles;
    }

    @Override
    public String toString() {
        return """
                MunicipioDTO{\
                id_municipio=\
                """ + id_municipio +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
