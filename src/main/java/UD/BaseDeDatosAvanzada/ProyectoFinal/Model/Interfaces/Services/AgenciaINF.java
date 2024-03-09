package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.AgenciaDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.AgenciaPK;
public interface AgenciaINF extends JpaRepository<AgenciaDTO, AgenciaPK> {
}
