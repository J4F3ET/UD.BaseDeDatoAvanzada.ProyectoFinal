package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.RegistroDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroINF extends JpaRepository<RegistroDTO,Long> {
}
