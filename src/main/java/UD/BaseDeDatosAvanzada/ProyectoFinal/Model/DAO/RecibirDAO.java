package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.RecibirINF;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.RecibirDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.RecibirPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecibirDAO {
    @Autowired
    private RecibirINF recibirINF;
    public void deleteById(RecibirPK id){
        recibirINF.deleteById(id);
    }
    public RecibirDTO save(RecibirDTO recibirDTO){
        return recibirINF.save(recibirDTO);
    }
    public Optional<RecibirDTO> findById(RecibirPK id){
        return recibirINF.findById(id);
    }
    public RecibirDTO saveById(RecibirPK id){
        return recibirINF.save(new RecibirDTO(id));
    }
    public RecibirDTO updateById(RecibirPK id,RecibirDTO recibirDTO){
        recibirINF.deleteById(id);
        return recibirINF.save(recibirDTO);
    }
}
