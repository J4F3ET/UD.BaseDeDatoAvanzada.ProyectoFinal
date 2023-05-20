package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.RegistroDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository Esta etiqueta indica que la clase es un repositorio, es decir, una clase que se encarga de gestionar la
 * capa de persistencia, permitiendo realizar las operaciones básicas (CRUD) sobre la tabla que representa la entidad
 * RegistroDTO.
 * @Interface RegistroINF
 * Interface que hereda de JpaRepository para poder utilizar los metodos de JPA para RegistroDTO.
 */
@Repository
public interface RegistroINF extends JpaRepository<RegistroDTO,Long> {
}
