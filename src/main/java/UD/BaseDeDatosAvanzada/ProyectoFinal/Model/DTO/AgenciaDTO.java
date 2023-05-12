package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;

import java.util.ArrayList;

/**
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