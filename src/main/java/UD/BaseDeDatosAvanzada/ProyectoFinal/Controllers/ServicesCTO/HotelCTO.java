package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.HotelDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.HotelDTO;
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
}
