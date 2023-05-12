package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.HotelDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelINF extends JpaRepository<HotelDTO,Long> {
}
