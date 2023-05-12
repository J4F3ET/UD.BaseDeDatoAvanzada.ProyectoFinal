package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Telefono_UsuarioDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Telefono_UsuarioPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Telefono_UsuarioINF extends JpaRepository<Telefono_UsuarioDTO, Telefono_UsuarioPK> {
}
