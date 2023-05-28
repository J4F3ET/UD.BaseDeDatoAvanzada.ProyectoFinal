package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Repository Esta etiqueta indica que la clase es un repositorio, es decir, una clase que se encarga de gestionar la
 * capa de persistencia, permitiendo realizar las operaciones básicas (CRUD) sobre la tabla que representa la entidad
 * UsuarioDTO.
 * @Interface UsuarioINF
 * Interface que hereda de JpaRepository para poder utilizar los metodos de JPA para UsuarioDTO.
 */
@Repository
public interface UsuarioINF extends JpaRepository<UsuarioDTO,Long> {
    /**
     * Metodo que permite saber si existe un UsuarioDTO con el Alias.
     * @Query:   SELECT u.*
     *           FROM UsuarioDTO u
     *           WHERE u.alias = Alias;
     * @param alias Este parametro representa el alias del registro a obtener.
     * @return UsuarioDTO
     */
    @Query("SELECT u FROM UsuarioDTO u WHERE u.alias = :alias")
    UsuarioDTO findByAlias(String alias);

    /**
     * Metodo que permite saber si existe un UsuarioDTO con el id y contrasena.
     * @Query   SELECT u.*
     *          FROM UsuarioDTO u
     *          WHERE u.id_usuario = id_usuario AND u.contrasena = contrasena;
     * @param  alias Este parametro representa el alias del registro a obtener.
     * @param contrasena Este parametro representa la contrasena del registro a obtener.
     * @return UsuarioDTO
     */
    @Query("SELECT u FROM  UsuarioDTO u WHERE u.alias = :alias AND u.password = :contrasena")
    UsuarioDTO loginUsuario(String alias ,String contrasena);

}
