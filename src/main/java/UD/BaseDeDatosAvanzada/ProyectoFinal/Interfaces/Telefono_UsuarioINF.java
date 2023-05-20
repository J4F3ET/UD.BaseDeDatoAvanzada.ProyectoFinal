package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Telefono_UsuarioDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Telefono_UsuarioPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository Esta etiqueta indica que la clase es un repositorio, es decir, una clase que se encarga de gestionar la
 * capa de persistencia, permitiendo realizar las operaciones básicas (CRUD) sobre la tabla que representa la entidad
 * Telefono_usuarioDTO.
 * @Interface Telefono_UsuarioINF
 * Interface que hereda de JpaRepository para poder utilizar los metodos de JPA para Telefono_UsuarioDTO.
 */
@Repository
public interface Telefono_UsuarioINF extends JpaRepository<Telefono_UsuarioDTO, Telefono_UsuarioPK> {
}
