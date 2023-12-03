package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.RegistroINF;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.RegistroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistroDAO {
    @Autowired
    private RegistroINF registroINF;
    public void deleteById(long id){
        registroINF.deleteById(id);
    }
    public RegistroDTO save(RegistroDTO registroDTO){
        return registroINF.save(registroDTO);
    }
    public Optional<RegistroDTO> findById(long id){
        return registroINF.findById(id);
    }
    public RegistroDTO updateById(long id,RegistroDTO registroDTO){
        registroINF.deleteById(id);
        return registroINF.save(registroDTO);
    }

}
