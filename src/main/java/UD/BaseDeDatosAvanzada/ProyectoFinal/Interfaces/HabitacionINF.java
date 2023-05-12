package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.HabitacionDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitacionINF extends JpaRepository<HabitacionDTO,Long> {
}
