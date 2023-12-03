package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.AgenciaDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.AgenciaPK;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AgenciaINF extends JpaRepository<AgenciaDTO, AgenciaPK> {
}
