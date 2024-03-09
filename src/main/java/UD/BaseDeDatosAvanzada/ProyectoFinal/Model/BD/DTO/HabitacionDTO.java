package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "habitacion")
public class HabitacionDTO {

    @EmbeddedId
    private HabitacionPK habitacionPK;
    @Column
    private short max_huesped;
    @OneToMany(mappedBy = "habitacion", fetch = FetchType.LAZY, targetEntity = RegistroDTO.class)
    @JsonManagedReference
    private Collection<RegistroDTO> registros = new ArrayList<>();
    @OneToMany(mappedBy = "id.habitacion", fetch = FetchType.LAZY, targetEntity = RecibirDTO.class)
    @JsonManagedReference
    private Collection<RecibirDTO> reserva  = new ArrayList<>();
    @Transient
    private double costo;

    public HabitacionDTO() {
    }
    public HabitacionDTO(HabitacionDTO habitacionDTO, short max_huesped) {
        this.habitacionPK = habitacionDTO.getHabitacionPK();
        this.max_huesped = max_huesped;
        this.costo = max_huesped * (habitacionPK.getHotelDTO().getCategoria()*50000);
    }

    public HabitacionPK getHabitacionPK() {
        return habitacionPK;
    }

    public void setHabitacionPK(HabitacionPK habitacionPK) {
        this.habitacionPK = habitacionPK;
    }

    public short getMax_huesped() {
        return max_huesped;
    }

    public void setMax_huesped(short max_huesped) {
        this.max_huesped = max_huesped;
    }

    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HabitacionDTO that = (HabitacionDTO) o;
        return max_huesped == that.max_huesped && Double.compare(that.costo, costo) == 0 && Objects.equals(habitacionPK, that.habitacionPK) && Objects.equals(registros, that.registros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(habitacionPK, max_huesped, registros, costo);
    }

    @Override
    public String toString() {
        return """
                HabitacionDTO{\
                habitacionPK=\
                """ + habitacionPK +
                ", max_huesped=" + max_huesped +
                ", registros=" + registros +
                ", reserva=" + reserva +
                ", costo=" + costo +
                '}';
    }
}
