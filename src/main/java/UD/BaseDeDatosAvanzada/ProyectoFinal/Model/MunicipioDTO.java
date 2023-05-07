package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "municipio")
public class MunicipioDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_municipio;

    @Column
    private String nombre;

    public MunicipioDTO() {
    }
    public MunicipioDTO(int id_municipio, String nombre) {
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
