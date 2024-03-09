package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.UsarDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.UsarPK;

public interface UsarINF extends JpaRepository<UsarDTO, UsarPK> {
}
