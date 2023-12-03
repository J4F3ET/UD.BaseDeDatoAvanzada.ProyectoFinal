package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.MunicipioDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.MunicipioDTO;
@RestController
@RequestMapping("/municipio")
public class MunicipioCTO {
    @Autowired
    private MunicipioDAO respository;
    @GetMapping("/findAll/public")
    public Iterable<MunicipioDTO> findAll(){
        Iterable <MunicipioDTO> municipios = respository.findAll();
        municipios.forEach(municipioDTO -> {
            municipioDTO.setAgencias(null);
            municipioDTO.setHoteles(null);
        });
        return municipios;
    }


}
