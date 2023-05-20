package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.UsuarioDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.UsuarioDTO;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
/**
 * @RestController Esta etiqueta indica que la clase es un controlador, es decir, una clase que se encarga de gestionar
 * las peticiones que llegan desde el cliente.
 * @RequestMapping("/Usuario") Esta etiqueta indica que la ruta de acceso a la que se accede para gestionar las
 * peticiones es /Usuario.
 * @Class UsuarioCTO
 *
 */
@RestController
@RequestMapping("/Usuario")
public class UsuarioCTO {
    private UsuarioDAO usuarioDAO;
    public UsuarioCTO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    /**
     * @GetMapping("/listar") Esta etiqueta indica que la ruta de acceso a la que se accede para gestionar las
     * peticiones es /listar.
     * @RequestParam("pageNumber") Este parametro representa el numero de pagina a obtener.
     * @return ArrayList<UsuarioDTO>
     * Metodo que permite obtener todos los registros de la tabla que representa la entidad UsuarioDTO de la misma
     * forma estan asociados a su numero de telefono correspondiente.
     */
    @GetMapping("/listar{pageNumber}")
    public ArrayList<UsuarioDTO>listar(@RequestParam("pageNumber") int pageNumber){
        return (ArrayList<UsuarioDTO>) usuarioDAO.findAll(pageNumber);
    }
    /**
     * @GetMapping("/buscar/{id}") Esta etiqueta indica que la ruta de acceso a la que se accede para gestionar las
     * peticiones es /buscar/{id}.
     * @PathVariable("id") Este parametro representa el id del registro a obtener.
     * @return UsuarioDTO
     * Metodo que permite obtener un registro de la tabla que representa la entidad UsuarioDTO de la misma forma estan
     * asociados a su numero de telefono correspondiente.
     */
    @GetMapping("/buscar/{id}")
    public UsuarioDTO buscar(@PathVariable("id") Long id){
        return usuarioDAO.findById(id);
    }
    /**
     * @PostMapping(/login) Esta etiqueta indica que la ruta de acceso a la que se accede para gestionar las
     * peticiones es /login
     * @PathVariable("alias") Este parametro representa el alias del registro a obtener.
     * @PathVariable("contrasena") Este parametro representa la contrasena del registro a obtener.
     * @return boolean
     * Metodo que permite obtener un registro de la tabla que representa la entidad UsuarioDTO de la misma forma estan
     * asociados a su numero de telefono correspondiente.
     */
    @PostMapping("/login")
    public UsuarioDTO buscarPorAlias(@RequestParam("alias") String alias,@RequestParam("contrasena") String contrasena){
        return  usuarioDAO.loginUsuario(alias,contrasena);
    }
    /**
     * @PostMapping("/guardar") Esta etiqueta indica que la ruta de acceso a la que se accede para gestionar las
     * peticiones es /guardar.
     * @RequestBody Este parametro representa el objeto UsuarioDTO a guardar.
     * @return UsuarioDTO
     * Metodo que permite agregar un registro a la tabla que representa la entidad UsuarioDTO de la misma forma estan
     * asociados a su numero de telefono correspondiente.
     */
    @PostMapping("/guardar")
    public UsuarioDTO guardar(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioDAO.save(usuarioDTO);
    }
    /**
     * @PutMapping("/actualizar") Esta etiqueta indica que la ruta de acceso a la que se accede para gestionar las
     * peticiones es /actualizar.
     * @RequestBody Este parametro representa el objeto UsuarioDTO a actualizar.
     * @return UsuarioDTO
     * Metodo que permite actualizar un registro de la tabla que representa la entidad UsuarioDTO de la misma forma
     * estan asociados a su numero de telefono correspondiente.
     */
    @PutMapping("/actualizar")
    public UsuarioDTO actualizar(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioDAO.save(usuarioDTO);
    }
    /**
     * @DeleteMapping("/eliminar/{id}") Esta etiqueta indica que la ruta de acceso a la que se accede para gestionar
     * las peticiones es /eliminar/{id}.
     * @PathVariable("id") Este parametro representa el id del registro a eliminar.
     * Metodo que permite eliminar un registro de la tabla que representa la entidad UsuarioDTO de la misma forma estan
     * asociados a su numero de telefono correspondiente.
     */
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Long id){
        usuarioDAO.deleteById(id);
    }
}
