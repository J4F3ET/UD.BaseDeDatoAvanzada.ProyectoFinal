package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.ReservaDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaINF extends JpaRepository<ReservaDTO,Long> {
}
