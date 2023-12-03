package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Telefono_UsuarioDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Telefono_UsuarioPK;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.UsuarioDTO;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO.Util.TelefonoRequestUser;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.Telefono_UsuarioDAO;

@RestController
@RequestMapping("/telefono_usuario")
public class Telefono_UsuarioCTO {
    @Autowired
    private Telefono_UsuarioDAO telefono_usuarioDAO;

    @PostMapping("/listar")
    public ArrayList<String>  listar(@RequestBody UsuarioDTO user){
        ArrayList<String> response = new ArrayList<>();
        telefono_usuarioDAO.findByUser(user.getId_usuario()).forEach(telefono -> {
            response.add(""+telefono.getId().getTelefono());
        });
        return response;
    }
    @PostMapping("/guardar")
    public  Collection<Telefono_UsuarioDTO> guardar(@RequestBody TelefonoRequestUser request){
        Collection<Telefono_UsuarioDTO> telefonos = request.getTelefonos();
        Collection<Telefono_UsuarioDTO> response = new ArrayList<>();
        telefonos.forEach(telefono -> {
            if(telefono.getId().getTelefono()!=0 || telefono.getId().getUsuario() != null){
                response.add(this.telefono_usuarioDAO.save(telefono));
            }else{
                response.add(new Telefono_UsuarioDTO(new Telefono_UsuarioPK(0,new UsuarioDTO())));
            }
            
        });
        return response;
    }
}
