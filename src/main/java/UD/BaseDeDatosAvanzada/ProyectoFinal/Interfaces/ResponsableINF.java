package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.ResponsableDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.ResponsablePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsableINF extends JpaRepository<ResponsableDTO, ResponsablePK> {
}
