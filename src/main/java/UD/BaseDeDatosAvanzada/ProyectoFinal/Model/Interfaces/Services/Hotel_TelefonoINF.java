package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.Hotel_TelefonoDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.Hotel_TelefonoPK;
public interface Hotel_TelefonoINF extends JpaRepository<Hotel_TelefonoDTO, Hotel_TelefonoPK> {
}
