package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO.UsuarioDAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/usuario")
public class UsuarioCTO {
    @Autowired
    private UsuarioDAO usuarioDAO;

    @GetMapping("/listar{pageNumber}")
    public ArrayList<UsuarioDTO>listar(@RequestParam("pageNumber") int pageNumber){
        return (ArrayList<UsuarioDTO>) this.usuarioDAO.findAll(pageNumber);
    }

    @GetMapping("/buscar/{id}")
    public UsuarioDTO buscar(@PathVariable("id") Long id){
        return usuarioDAO.findById(id);
    }

    @PostMapping(value = "/guardar")
    public UsuarioDTO guardar(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioDAO.save(usuarioDTO);
    }

    @PutMapping("/actualizar")
    public UsuarioDTO actualizar(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioDAO.save(usuarioDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Long id){
        usuarioDAO.deleteById(id);
    }
}
