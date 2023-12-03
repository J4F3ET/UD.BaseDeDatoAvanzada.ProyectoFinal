package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.UsuarioINF;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.AgenciaDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.ResponsableDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Service
public class UsuarioDAO {
    @Autowired
    private UsuarioINF usuarioINF;
    public UsuarioDAO(UsuarioINF usuarioINF) {
        this.usuarioINF = usuarioINF;
    }
    public ArrayList<UsuarioDTO> findAll(int pageNumber) {
        int pageSize = 20;
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<UsuarioDTO> page = this.usuarioINF.findAll(pageable);
        return new ArrayList<>(page.getContent());
    }
    public UsuarioDTO findById(Long id) {
        return usuarioINF.findById(id).orElse(null);
    }
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        return usuarioINF.save(usuarioDTO);
    }
    public void delete(UsuarioDTO usuarioDTO) {
        usuarioINF.delete(usuarioDTO);
    }
    public void deleteById(Long id) {
        usuarioINF.deleteById(id);
    }
    public UsuarioDTO existsByAlias(String alias) {
        return usuarioINF.findByAlias(alias);
    }
    public UsuarioDTO loginUsuario(String alias, String contrasena) {
        return usuarioINF.loginUsuario(alias,contrasena);
    }
    public AgenciaDTO loginAgencia(String alias, String contrasena) {
        return usuarioINF.loginAgencia(alias,contrasena);
    }
    public ResponsableDTO loginResponsable(String alias, String contrasena) {
        return usuarioINF.loginResponsable(alias,contrasena);
    }
}
