package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.ResponsableDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.ResponsablePK;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.Services.ResponsableINF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponsableDAO {
    @Autowired
    private ResponsableINF responsableINF;
    public void deleteById(ResponsablePK id){
        responsableINF.deleteById(id);
    }
    public ResponsableDTO save(ResponsableDTO responsableDTO){
        return responsableINF.save(responsableDTO);
    }
    public ResponsableDTO updateById(ResponsablePK id,ResponsableDTO responsableDTO){
        responsableINF.deleteById(id);
        return responsableINF.save(responsableDTO);
    }
    public Optional<ResponsableDTO> findById(ResponsablePK id){
        return responsableINF.findById(id);
    }
}
