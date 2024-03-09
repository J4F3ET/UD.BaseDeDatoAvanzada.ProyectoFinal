package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.PagoDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.PagoPK;

public interface PagoINF extends JpaRepository<PagoDTO, PagoPK> {
}
