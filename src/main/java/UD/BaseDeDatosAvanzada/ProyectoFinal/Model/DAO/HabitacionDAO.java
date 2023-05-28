package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces.HabitacionINF;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.HabitacionDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.HabitacionPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HabitacionDAO {
    @Autowired
    private HabitacionINF habitacionINF;
    public void deleteById(HabitacionPK id){
        habitacionINF.deleteById(id);
    }
    public Optional<HabitacionDTO> findById(HabitacionPK id){
        return habitacionINF.findById(id);
    }
    public HabitacionDTO save(HabitacionDTO habitacionDTO){
        return habitacionINF.save(habitacionDTO);
    }
    public void updateById(HabitacionPK habitacionPK,HabitacionDTO nuevoHabitacionDTO){
        habitacionINF.deleteById(habitacionPK);
        habitacionINF.save(nuevoHabitacionDTO);
    }

}
