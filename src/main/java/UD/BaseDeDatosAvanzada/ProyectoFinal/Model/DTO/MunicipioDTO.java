package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;

import java.util.ArrayList;

/**
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
    private ArrayList<AgenciaDTO> agencias = new ArrayList<>();

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
}
