package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.ReservaDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.Services.ReservaINF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaDAO {
    @Autowired
    private ReservaINF reservaINF;
    public void deleteById(long id){
        reservaINF.deleteById(id);
    }
    public ReservaDTO save(ReservaDTO reservaDTO){
        return reservaINF.save(reservaDTO);
    }
    public ReservaDTO updateById(long id,ReservaDTO reservaDTO){
        reservaINF.deleteById(id);
        return reservaINF.save(reservaDTO);
    }
    public Optional<ReservaDTO> findById(long id){
        return reservaINF.findById(id);
    }

}
