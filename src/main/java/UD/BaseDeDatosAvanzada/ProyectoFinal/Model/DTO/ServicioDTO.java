package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "servicio")
public class ServicioDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_servicio;
    @Column
    private String nombre;
    @Column
    private int costo;

    public ServicioDTO() {
    }
    public ServicioDTO(String nombre, int costo) {
        this.nombre = nombre;
        this.costo = costo;
    }
    public long getId_servicio() {
        return id_servicio;
    }
    public String getNombre() {
        return this.nombre;
    }
    public int getCosto() {
        return this.costo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }
    public void setId_servicio(long id_servicio) {
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
