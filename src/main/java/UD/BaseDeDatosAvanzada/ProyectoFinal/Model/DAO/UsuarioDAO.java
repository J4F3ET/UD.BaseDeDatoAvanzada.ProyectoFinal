package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces.UsuarioINF;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Service Esta etiqueta indica que la clase es un servicio, es decir, una clase que se encarga de gestionar la
 * capa de negocio, permitiendo realizar las operaciones básicas (CRUD) sobre la tabla que representa la entidad
 * UsuarioDTO.
 * @Autowired Esta etiqueta permite la inyeccion de dependencias, es decir, permite que se puedan utilizar los metodos
 * de la interface UsuarioINF.
 * Clase que permite realizar las operaciones basicas (CRUD) sobre la tabla que representa la entidad UsuarioDTO.
 */
@Service
public class UsuarioDAO {
    private UsuarioINF usuarioINF;
    public UsuarioDAO(UsuarioINF usuarioINF) {
        this.usuarioINF = usuarioINF;
    }

    /**
     * Metodo que permite obtener todos los registros de la tabla que representa la entidad UsuarioDTO.
     * @return Iterable<UsuarioDTO>
     */
    public ArrayList<UsuarioDTO> findAll() {
        /**
         * Pageable es una interfaz que define un conjunto de métodos para obtener información sobre la
         * configuración de la página actual.
         * PageRequest es una clase que implementa la interfaz Pageable.
         * PageRequest.of() Este metodo permite crear un objeto PageRequest.
         * PageRequest.of(pageNumber, pageSize, sort) Este metodo permite crear un objeto PageRequest con los parametros
         * pageNumber, pageSize y sort.
         */
        int pageSize = 20;
        int pageNumber = 0;
        Sort sort = Sort.by(Sort.Direction.ASC, "id_usuario");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<UsuarioDTO> page = usuarioINF.findAll(pageable);
        return (ArrayList<UsuarioDTO>) page.getContent();
    }
    /**
     * Metodo que permite obtener un registro de la tabla que representa la entidad UsuarioDTO.
     * @param id Este parametro representa el id del registro a obtener.
     * @return UsuarioDTO
     */
    public UsuarioDTO findById(Long id) {
        /**
         * Optional<UsuarioDTO> Este objeto permite retornar el objeto UsuarioDTO si lo encuentra.
         * orElse(null) Este metodo permite retornar null si no encuentra el objeto UsuarioDTO.
         */
        return usuarioINF.findById(id).orElse(null);
    }
    /**
     * Metodo que permite agregar un registro a la tabla que representa la entidad UsuarioDTO.
     * @param usuarioDTO Este parametro representa el objeto UsuarioDTO a guardar.
     * @return UsuarioDTO
     */
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        return usuarioINF.save(usuarioDTO);
    }
    /**
     * Metodo que permite eliminar un registro de la tabla que representa la entidad UsuarioDTO.
     * @param usuarioDTO Este parametro representa el objeto UsuarioDTO a eliminar.
     */
    public void delete(UsuarioDTO usuarioDTO) {
        usuarioINF.delete(usuarioDTO);
    }
    /**
     * Metodo que permite eliminar un registro de la tabla que representa la entidad UsuarioDTO.
     * @param id Este parametro representa el id del registro a eliminar.
     */
    public void deleteById(Long id) {
        usuarioINF.deleteById(id);
    }
}
