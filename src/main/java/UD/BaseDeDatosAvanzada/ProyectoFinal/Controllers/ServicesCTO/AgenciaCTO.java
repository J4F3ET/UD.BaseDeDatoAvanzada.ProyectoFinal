package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.AgenciaDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.MunicipioDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.UsuarioDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.Telefono_UsuarioDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/agencia")
public class AgenciaCTO {
    @Autowired
    private AgenciaDAO agenciaDAO;
    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private MunicipioDAO municipioDAO;

    @Autowired
    private Telefono_UsuarioDAO telefono_usuarioDAO;
    @PostMapping("/guardar")
    public ResponseEntity<String> registrarAgencia(@RequestBody AgenciaUsuarioDTO agenciaUsuarioDTO){
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        AgenciaDTO agenciaDTO = new AgenciaDTO();
        Optional<MunicipioDTO> municipioOPT =  this.municipioDAO.findById(Long.parseLong(agenciaUsuarioDTO.getMunicipio()));
        MunicipioDTO municipioDTO = municipioOPT.orElse(null);
        if (municipioDTO==null){
            return ResponseEntity.badRequest().build();
        }
        usuarioDTO.setAlias(agenciaUsuarioDTO.getAlias());
        usuarioDTO.setPassword(agenciaUsuarioDTO.getPassword());
        usuarioDTO.setCorreo(agenciaUsuarioDTO.getCorreo_electronico());
        usuarioDTO.setDireccion(agenciaUsuarioDTO.getDireccion());
        usuarioDTO.setNombre(agenciaUsuarioDTO.getNombre_agencia());
        usuarioDTO =this.usuarioDAO.save(usuarioDTO);

        AgenciaPK agenciaPK = new AgenciaPK(
                Integer.parseInt(agenciaUsuarioDTO.getRnt_agencia())
                ,usuarioDTO
        );
        Telefono_UsuarioPK telefono_usuarioPK = new Telefono_UsuarioPK(
                Long.parseLong(agenciaUsuarioDTO.getTelefono()),
                usuarioDTO
        );
        this.telefono_usuarioDAO.saveById(telefono_usuarioPK);
        agenciaDTO.setNombre_agencia(agenciaUsuarioDTO.getNombre_agencia());
        agenciaDTO.setId(agenciaPK);
        agenciaDTO.setMunicipio(municipioDTO);
        agenciaDTO = this.agenciaDAO.save(agenciaDTO);
        return ResponseEntity.ok("" + agenciaDTO.getId().toString());
    }
}
