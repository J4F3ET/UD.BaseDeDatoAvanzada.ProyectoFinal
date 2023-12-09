package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.HabitacionDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.HabitacionPK;
public interface HabitacionINF extends JpaRepository<HabitacionDTO, HabitacionPK> {
}
