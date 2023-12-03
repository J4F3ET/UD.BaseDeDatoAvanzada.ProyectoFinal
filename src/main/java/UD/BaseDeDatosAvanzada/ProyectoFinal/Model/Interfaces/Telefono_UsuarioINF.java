package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Telefono_UsuarioDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Telefono_UsuarioPK;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Telefono_UsuarioINF extends JpaRepository<Telefono_UsuarioDTO, Telefono_UsuarioPK> {
    @Query("SELECT t FROM Telefono_UsuarioDTO t WHERE t.telefono_usuarioPK.usuario.id = :id_usuario")
    Collection<Telefono_UsuarioDTO> getTelefonosByUsuario(Long id_usuario);
}
