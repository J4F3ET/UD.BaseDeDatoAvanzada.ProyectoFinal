package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces.MunicipioINF;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.MunicipioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MunicipioDAO {
    @Autowired
    private MunicipioINF municipioINF;
    public Iterable<MunicipioDTO> findAll(){
        return municipioINF.findAll();
    }
    public Optional<MunicipioDTO> findById(Long id){
        return  municipioINF.findById(id);
    }
    public MunicipioDTO save(MunicipioDTO municipioDTO){
        return municipioINF.save(municipioDTO);
    }
    public void deleteById(Long id){
        municipioINF.deleteById(id);
    }
    public void updateById(Long municipioPK,MunicipioDTO nuevoMunicipioDTO){
        municipioINF.deleteById(municipioPK);
        municipioINF.save(nuevoMunicipioDTO);
    }

}
