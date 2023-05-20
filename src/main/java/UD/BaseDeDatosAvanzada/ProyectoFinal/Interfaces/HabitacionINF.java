package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.HabitacionDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.HabitacionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository Esta etiqueta indica que la clase es un repositorio, es decir, una clase que se encarga de gestionar la
 * capa de persistencia, permitiendo realizar las operaciones básicas (CRUD) sobre la tabla que representa la entidad
 * HabitacionDTO.
 * @Interface HabitacionINF
 * Interface que hereda de JpaRepository para poder utilizar los metodos de JPA para HabitacionDTO.
 */
@Repository
public interface HabitacionINF extends JpaRepository<HabitacionDTO, HabitacionPK> {
}
