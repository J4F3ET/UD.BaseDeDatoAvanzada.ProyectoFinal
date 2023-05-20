package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.AgenciaDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.AgenciaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository Esta etiqueta indica que la clase es un repositorio, es decir, una clase que se encarga de gestionar la
 * capa de persistencia, permitiendo realizar las operaciones básicas (CRUD) sobre la tabla que representa la entidad
 * AgenciaDTO.
 * @Interface AgenciaINF
 * Interface que hereda de JpaRepository para poder utilizar los metodos de JPA para AgenciaDTO.
 */
@Repository
public interface AgenciaINF extends JpaRepository<AgenciaDTO, AgenciaPK> {
}
