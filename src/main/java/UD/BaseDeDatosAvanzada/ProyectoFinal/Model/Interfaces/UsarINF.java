package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.UsarDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.UsarPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsarINF extends JpaRepository<UsarDTO, UsarPK> {
}
