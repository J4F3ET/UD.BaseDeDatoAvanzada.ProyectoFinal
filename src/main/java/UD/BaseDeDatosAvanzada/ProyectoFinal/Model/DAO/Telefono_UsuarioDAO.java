package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces.Telefono_UsuarioINF;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Telefono_UsuarioDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Telefono_UsuarioPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class Telefono_UsuarioDAO {
    @Autowired
    private Telefono_UsuarioINF telefono_usuarioINF;
    public void deleteById(Telefono_UsuarioPK id){
        telefono_usuarioINF.deleteById(id);
    }
    public Collection<Telefono_UsuarioDTO> findByUser(Long id_usuario){
        return telefono_usuarioINF.getTelefonosByUsuario(id_usuario);
    };
    public void updateById(Telefono_UsuarioPK telefono_usuarioPK,Telefono_UsuarioPK nuevoTelefono_usuarioPK){
        telefono_usuarioINF.deleteById(telefono_usuarioPK);
        telefono_usuarioINF.save(new Telefono_UsuarioDTO(nuevoTelefono_usuarioPK));
    }
    public Telefono_UsuarioDTO save(Telefono_UsuarioDTO telefono_usuarioDTO){
        System.out.println(telefono_usuarioDTO.toString());
        return telefono_usuarioINF.save(telefono_usuarioDTO);
    }
    public Optional<Telefono_UsuarioDTO> findById(Telefono_UsuarioPK id){
        return telefono_usuarioINF.findById(id);
    }
    public Telefono_UsuarioDTO saveById(Telefono_UsuarioPK id){
        return telefono_usuarioINF.save(new Telefono_UsuarioDTO(id));
    }

}
