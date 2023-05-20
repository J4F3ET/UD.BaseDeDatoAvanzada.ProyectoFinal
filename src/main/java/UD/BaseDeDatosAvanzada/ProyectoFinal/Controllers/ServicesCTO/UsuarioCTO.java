package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.UsuarioDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.UsuarioDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/listar")
    public ArrayList<UsuarioDTO>listar() {
        return (ArrayList<UsuarioDTO>) usuarioDAO.findAll();
    }
}
