package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.AgenciaDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces.AgenciaINF;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.AgenciaPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenciaDAO {
    @Autowired
    private AgenciaINF agenciaINF;

    public AgenciaDTO findById(AgenciaPK id){
        return this.agenciaINF.findById(id).orElse(null);
    }
    public AgenciaDTO save(AgenciaDTO agenciaDTO){
        return this.agenciaINF.save(agenciaDTO);
    }
    public void deleteById(AgenciaPK id){
        this.agenciaINF.deleteById(id);
    }
    public void updateById(AgenciaPK agenciaPK,AgenciaDTO nuevoAgenciaDTO){
        this.agenciaINF.deleteById(agenciaPK);
        this.agenciaINF.save(nuevoAgenciaDTO);
    }
}