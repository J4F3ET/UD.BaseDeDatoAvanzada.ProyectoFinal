package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.RegistroDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.HabitacionDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.RegistroDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.ReservaDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/registro")
public class RegistroCTO {
    @Autowired
    private RegistroDAO registroDAO;
    @Autowired
    private ReservaDAO reservaDAO;
    @Autowired
    private HabitacionDAO habitacionDAO;
    @PostMapping(value = "/guardar")
    public ResponseEntity<String> guardarRegistro(@RequestBody  RegistroDTO registroDTO){
        if(
                (this.reservaDAO.findById(registroDTO.getReserva().getId_reserva())==null)||
                (this.habitacionDAO.findById(registroDTO.getHabitacion().getHabitacionPK())==null)
        ){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(""+this.registroDAO.save(registroDTO).getId_registro());
    }
}
