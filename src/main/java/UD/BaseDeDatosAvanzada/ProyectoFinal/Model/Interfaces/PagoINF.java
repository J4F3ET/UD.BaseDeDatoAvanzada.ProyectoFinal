package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.PagoDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.PagoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoINF extends JpaRepository<PagoDTO, PagoPK> {
}
