package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.ServicioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.ServicioINF;

import java.util.Optional;

@Service
public class ServicioDAO {
    @Autowired
    private ServicioINF servicioINF;
    public void deleteById(int id){
        servicioINF.deleteById(id);
    }
    public ServicioDTO save(ServicioDTO servicioDTO){
        return servicioINF.save(servicioDTO);
    }
    public Optional<ServicioDTO> findById(int id){
        return servicioINF.findById(id);
    }
    public ServicioDTO updateById(int id,ServicioDTO servicioDTO){
        servicioINF.deleteById(id);
        return servicioINF.save(servicioDTO);
    }

}
