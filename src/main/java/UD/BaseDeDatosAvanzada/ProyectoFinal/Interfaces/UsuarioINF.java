package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioINF extends JpaRepository<UsuarioDTO,Long> {
}
