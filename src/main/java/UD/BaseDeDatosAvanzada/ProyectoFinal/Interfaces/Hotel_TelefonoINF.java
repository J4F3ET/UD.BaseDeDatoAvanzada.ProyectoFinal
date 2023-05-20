package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Hotel_TelefonoDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Hotel_TelefonoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository Esta etiqueta indica que la clase es un repositorio, es decir, una clase que se encarga de gestionar la
 * capa de persistencia, permitiendo realizar las operaciones básicas (CRUD) sobre la tabla que representa la entidad
 * Hotel_telefonoDTO.
 * @Interface Hotel_TelefonoINF
 * Interface que hereda de JpaRepository para poder utilizar los metodos de JPA para Hotel_TelefonoDTO.
 */
@Repository
public interface Hotel_TelefonoINF extends JpaRepository<Hotel_TelefonoDTO, Hotel_TelefonoPK> {
}
