package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.HotelDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.DTO.IHotelPublicDTO;
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
    public Iterable<IHotelPublicDTO> findAll(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "0") int id_municipio,
            @RequestParam(required = false, defaultValue = "0") int categoria) {
        Iterable<IHotelPublicDTO> hoteles = null;
        if (id_municipio == 0 && categoria == 0) {
            hoteles = this.hotelDAO.findAllHotelProjection(pageNumber);
        } else if (id_municipio != 0 && categoria == 0) {
            hoteles = this.hotelDAO.findByCity(pageNumber, id_municipio);
        } else if (id_municipio == 0 && categoria != 0) {
            hoteles = this.hotelDAO.findByCategoria(pageNumber, categoria);
        } else {
            hoteles = this.hotelDAO.findByDoubleFilter(pageNumber, id_municipio, categoria);
        }
        return hoteles;
    }
}
