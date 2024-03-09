package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.Hotel_TelefonoDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.Hotel_TelefonoPK;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.Services.Hotel_TelefonoINF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Hotel_TelefonoDAO {
    @Autowired
    private Hotel_TelefonoINF hotel_telefonoINF;
    public void deleteById(Hotel_TelefonoPK id){
        hotel_telefonoINF.deleteById(id);
    }
    public Optional<Hotel_TelefonoDTO> findById(Hotel_TelefonoPK id){
        return hotel_telefonoINF.findById(id);
    }
    public Hotel_TelefonoDTO save(Hotel_TelefonoDTO hotel_telefonoDTO){
        return hotel_telefonoINF.save(hotel_telefonoDTO);
    }
    public Hotel_TelefonoDTO saveById(Hotel_TelefonoPK hotel_telefonoPK){
        return hotel_telefonoINF.save(new Hotel_TelefonoDTO(hotel_telefonoPK));
    }
    public void updateById(Hotel_TelefonoPK hotel_telefonoPK,Hotel_TelefonoDTO nuevoHotel_TelefonoDTO){
        hotel_telefonoINF.deleteById(hotel_telefonoPK);
        hotel_telefonoINF.save(nuevoHotel_TelefonoDTO);
    }

}
