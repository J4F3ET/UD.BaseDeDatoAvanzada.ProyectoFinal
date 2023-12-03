package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.HabitacionDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.HabitacionPK;
import org.springframework.data.jpa.repository.JpaRepository;
public interface HabitacionINF extends JpaRepository<HabitacionDTO, HabitacionPK> {
}
