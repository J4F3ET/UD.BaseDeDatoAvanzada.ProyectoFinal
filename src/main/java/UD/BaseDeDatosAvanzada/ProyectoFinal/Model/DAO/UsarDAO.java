package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces.RegistroINF;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces.UsarINF;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.UsarDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.UsarPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsarDAO {
    @Autowired
    private UsarINF usarINF;
    public void deleteById(UsarPK id){
        usarINF.deleteById(id);
    }
    public UsarDTO save(UsarDTO usarDTO){
        return usarINF.save(usarDTO);
    }
    public UsarDTO updateById(UsarPK id,UsarDTO usarDTO){
        usarINF.deleteById(id);
        return usarINF.save(usarDTO);
    }
    public Optional<UsarDTO> findById(UsarPK id){
        return usarINF.findById(id);
    }
}
