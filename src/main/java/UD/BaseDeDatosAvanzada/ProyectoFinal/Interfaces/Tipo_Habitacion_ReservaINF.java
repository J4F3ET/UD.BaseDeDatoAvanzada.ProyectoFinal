package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Tipo_Habitacion_ReservaDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Tipo_Habitacion_ReservaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository Esta etiqueta indica que la clase es un repositorio, es decir, una clase que se encarga de gestionar la
 * capa de persistencia, permitiendo realizar las operaciones básicas (CRUD) sobre la tabla que representa la entidad
 * Tipo_Habitacion_ReservaDTO.
 * @Interface Tipo_Habitacion_ReservaINF
 * Interface que hereda de JpaRepository para poder utilizar los metodos de JPA para Tipo_Habitacion_ReservaDTO.
 */
@Repository
public interface Tipo_Habitacion_ReservaINF extends JpaRepository<Tipo_Habitacion_ReservaDTO, Tipo_Habitacion_ReservaPK>{
}
