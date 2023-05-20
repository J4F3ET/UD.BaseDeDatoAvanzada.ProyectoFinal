package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import jakarta.persistence.*;
/**
 * @Entity Clase que define los atributos para el objeto ServicioDTO.
 * @Table indica que la clase es una entidad y que se mapea a una tabla de base de datos
 * @Id indica que el atributo es una clave primaria
 * @GeneratedValue indica que el atributo es autogenerado
 * @Column indica el nombre de la columna en la tabla
 * Clase que representa los atributos la tabla ServicioDTO de la base de datos.
 */
@Entity
@Table(name = "servicio")
public class ServicioDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_servicio;
    @Column(length = 50)
    private String nombre;
    @Column
    private double costo;

    public ServicioDTO() {
    }
    public ServicioDTO(String nombre, int costo) {
        this.nombre = nombre;
        this.costo = costo;
    }
    public int getId_servicio() {
        return id_servicio;
    }
    public String getNombre() {
        return this.nombre;
    }
    public double getCosto() {
        return this.costo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    @Override
    public String toString() {
        return "ServicioDTO{" +
                "id_servicio=" + id_servicio +
                ", nombre='" + nombre + '\'' +
                ", costo=" + costo +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServicioDTO)) return false;
        ServicioDTO that = (ServicioDTO) o;
        return getId_servicio() == that.getId_servicio() && getCosto() == that.getCosto() && getNombre().equals(that.getNombre());
    }
}
