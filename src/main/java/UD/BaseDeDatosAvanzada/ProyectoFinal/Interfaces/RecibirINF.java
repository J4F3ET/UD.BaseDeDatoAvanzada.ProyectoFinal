package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.RecibirDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.RecibirPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecibirINF extends JpaRepository<RecibirDTO, RecibirPK> {
}
