package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.ResponsableDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.Telefono_UsuarioDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.UsuarioDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/responsable")
public class ResponsableCTO {
    @Autowired
    private ResponsableDAO responsableDAO;
    @Autowired
    private Telefono_UsuarioDAO telefono_usuarioDAO;
    @Autowired
    private UsuarioDAO usuarioDAO;
    @PostMapping(value = "/guardar")
    public ResponseEntity<String> guardarResponsable(@RequestBody @NotNull ResponsableUsuarioDTO responsableUsuarioDTO){
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                responsableUsuarioDTO.getNombre(),
                responsableUsuarioDTO.getCorreo(),
                responsableUsuarioDTO.getPassword(),
                responsableUsuarioDTO.getAlias(),
                responsableUsuarioDTO.getDireccion()
        );
        usuarioDTO = this.usuarioDAO.save(usuarioDTO);
        ResponsablePK responsablePK = new ResponsablePK(responsableUsuarioDTO.getIdentificacion(),usuarioDTO);
        this.telefono_usuarioDAO.saveById(
                new Telefono_UsuarioPK(responsableUsuarioDTO.getTelefonoCelular(),usuarioDTO)
        );
        ResponsableDTO responsableDTO = new ResponsableDTO(responsablePK,responsableUsuarioDTO.getCategoria());
        return ResponseEntity.ok(""+(this.responsableDAO.save(responsableDTO)).toString());
    }

}
