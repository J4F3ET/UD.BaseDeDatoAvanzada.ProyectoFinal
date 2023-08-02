package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.ServicioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ServicioINF extends JpaRepository<ServicioDTO,Integer> {
}
