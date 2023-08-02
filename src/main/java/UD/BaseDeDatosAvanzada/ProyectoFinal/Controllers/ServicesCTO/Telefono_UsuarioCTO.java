package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Telefono_UsuarioDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.UsuarioDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO.Util.TelefonoRequestUser;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.Telefono_UsuarioDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.UsuarioDAO;

@RestController
@RequestMapping("/telefono_usuario")
public class Telefono_UsuarioCTO {
    @Autowired
    private Telefono_UsuarioDAO telefono_usuarioDAO;

    @PostMapping("/listar")
    public Optional<Telefono_UsuarioDTO> listar(@RequestBody Telefono_UsuarioDTO telefono_usuarioDTO){
        return this.telefono_usuarioDAO.findById(telefono_usuarioDTO.getId());
    }
    @PostMapping("/guardar")
    public  Collection<Telefono_UsuarioDTO> guardar(@RequestBody TelefonoRequestUser request){
        System.out.print("\n----------PRUEBAAAA--------------\n");
        System.out.print("\n----------------------------\n"+request.toString()+"\n------------------------\n");
        Collection<Telefono_UsuarioDTO> telefonos = request.getTelefonos();
        Collection<Telefono_UsuarioDTO> response = new ArrayList<>();
        telefonos.forEach(telefono -> {
            System.out.print("\n----------------------------\n"+telefono.toString()+"\n------------------------\n");
            response.add(this.telefono_usuarioDAO.save(telefono));
        });
        return response;
    }

}
