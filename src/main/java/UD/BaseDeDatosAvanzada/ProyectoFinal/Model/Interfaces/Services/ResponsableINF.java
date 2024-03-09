package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.ResponsableDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.ResponsablePK;

public interface ResponsableINF extends JpaRepository<ResponsableDTO, ResponsablePK> {
}
