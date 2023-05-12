package UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Tipo_Habitacion_ReservaDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Tipo_Habitacion_ReservaPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tipo_Habitacion_ReservaINF extends JpaRepository<Tipo_Habitacion_ReservaDTO, Tipo_Habitacion_ReservaPK>{
}
