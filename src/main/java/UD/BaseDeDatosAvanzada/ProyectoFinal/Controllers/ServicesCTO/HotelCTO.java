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
     * 
     * @param pageNumber es el numero de pagina que se desea obtener
     * 
     * @param id_municipio es el id del municipio en donde quiere el hotel
     * 
     * @param categoria es la categoria del hotel
     */
    @GetMapping(value = "/findAll/public")
    public Iterable<HotelDTO> findAll(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "0") int id_municipio,
            @RequestParam(required = false, defaultValue = "0") int categoria) {
        System.out.println("id_municipio: " + id_municipio);
        System.out.println("categoria: " + categoria);
        System.out.println("pageNumber: " + pageNumber);
        Iterable<HotelDTO> hoteles = null;
        if (id_municipio == 0 && categoria == 0) {
            hoteles = this.hotelDAO.findAll(pageNumber);
        } else if (id_municipio != 0 && categoria == 0) {
            hoteles = this.hotelDAO.findByCity(pageNumber, id_municipio);
        } else if (id_municipio == 0 && categoria != 0) {
            hoteles = this.hotelDAO.findByCategoria(pageNumber, categoria);
        } else {
            hoteles = this.hotelDAO.findByDoubleFilter(pageNumber, id_municipio, categoria);
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
