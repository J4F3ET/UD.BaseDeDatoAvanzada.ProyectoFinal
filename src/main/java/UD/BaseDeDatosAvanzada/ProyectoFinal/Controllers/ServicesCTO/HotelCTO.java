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
    public Iterable<HotelDTO> findByCategoria(@RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "Corriente") String categoria) {
        if (categoria == "Corriente")
            return this.hotelDAO.findByCategoria(pageNumber, 3);
        else
            return this.hotelDAO.findByCategoria(pageNumber, 5);
    }
    /*
     * findAll es una funcion que retorna los hoteles que se encuentran en la base
     * de datos, deacuerdo a los parametros que reciba retorna uno u otros hoteles
     * @param pageNumber es el numero de pagina que se desea obtener
     * @param filter es el filtro que se desea aplicar a la busqueda
     * @param value es el id del municipio en donde quiere el hotel
     * @param value2 es la categoria del hotel
     */
    @GetMapping(value = "/findAll/public")
    public Iterable<HotelDTO> findAll(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(required = false,defaultValue = "None") String filter,
            @RequestParam(required = false,defaultValue = "0") int value,
            @RequestParam(required = false,defaultValue = "0") int value2) {
        Iterable<HotelDTO> hoteles = null;
        System.out.println(value+""+value2+""+filter+""+pageNumber);
        switch (filter) {
            case "Category":
                hoteles = this.hotelDAO.findByCategoria(pageNumber, value2);
            break;
            case "City":
                hoteles = this.hotelDAO.findByCity(pageNumber, value);
            break;
            case "Both":
                hoteles = this.hotelDAO.findByDoubleFilter(pageNumber, value, value2); 
            break;
            default:
                hoteles = this.hotelDAO.findAll(pageNumber);
            break;
        }
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
            hotelDTO.setAntiguedad((LocalDate.now()).getYear() - hotelDTO.getAnio_inauguracion());
            for (String a : aux) {
                hotelDTO.setNombre(hotelDTO.getNombre().replace(a, ""));
            }
        });
        return hoteles;
    }
}
