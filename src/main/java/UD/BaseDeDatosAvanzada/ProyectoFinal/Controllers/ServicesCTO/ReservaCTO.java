package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.ReservaDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.ReservaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva")
public class ReservaCTO {
    @Autowired
    private ReservaDAO respository;
    @PostMapping("/crear")
    public ResponseEntity<String>  registrarReserva(@RequestBody ReservaDTO reserva){
        reserva = respository.save(reserva);
        return ResponseEntity.ok("" + reserva.toString());
    }

}
