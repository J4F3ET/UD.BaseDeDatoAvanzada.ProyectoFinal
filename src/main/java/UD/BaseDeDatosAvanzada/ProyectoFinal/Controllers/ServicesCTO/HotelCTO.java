package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.HotelDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.HotelDTO;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hotel")
public class HotelCTO {
    @Autowired
    private HotelDAO hotelDAO;
    @GetMapping(value = "/findByCategoria")
    public Iterable<HotelDTO> findByCategoria(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "Corriente") String categoria){
        if(categoria=="Corriente")
            return this.hotelDAO.findByCategoria(pageNumber,3);
        else
            return this.hotelDAO.findByCategoria(pageNumber,5);
    }
    @GetMapping(value = "/findAll/public")
    public Iterable<HotelDTO> findAll(@RequestParam(defaultValue = "0") int pageNumber){
        Iterable<HotelDTO> hoteles = this.hotelDAO.findAll(pageNumber);
        String[] aux = {
            "S.A.S.",
            " S.A.S",
            " S A S",
            "S.A.",
            "S A",
            "LTDA.",
            "LTDA",
            "LIMITADA",
            "REORGANIZACIÓN",
            "& CIA S.EN C."
        };
        hoteles.forEach(hotelDTO -> {
            hotelDTO.setHabitaciones(null);
            hotelDTO.setFecha_actualizacion(null);
            hotelDTO.setAntiguedad((LocalDate.now()).getYear()-hotelDTO.getAnio_inauguracion());
            for(String a:aux){
                hotelDTO.setNombre(hotelDTO.getNombre().replace(a,""));
            }
        });
        return hoteles;
    }
}
