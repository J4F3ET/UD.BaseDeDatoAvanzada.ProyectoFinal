package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.RecibirDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.RecibirPK;

public interface RecibirINF extends JpaRepository<RecibirDTO, RecibirPK> {
}
