package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Hotel_TelefonoDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Hotel_TelefonoPK;
import org.springframework.data.jpa.repository.JpaRepository;
public interface Hotel_TelefonoINF extends JpaRepository<Hotel_TelefonoDTO, Hotel_TelefonoPK> {
}
