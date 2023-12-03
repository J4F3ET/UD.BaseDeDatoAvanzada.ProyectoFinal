package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.AgenciaDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.ResponsableDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface UsuarioINF extends JpaRepository<UsuarioDTO,Long> {
    @Query("SELECT u FROM UsuarioDTO u WHERE u.alias = :alias")
    UsuarioDTO findByAlias(String alias);
    @Query("SELECT u FROM  UsuarioDTO u WHERE u.alias = :alias AND u.password = :contrasena")
    UsuarioDTO loginUsuario(String alias ,String contrasena);
    @Query("SELECT r FROM UsuarioDTO u RIGHT JOIN ResponsableDTO r ON(u.id = r.id.usuario.id) WHERE u.nombre = :nombre and u.password = :password")
    ResponsableDTO loginResponsable(String nombre, String password);
    @Query("SELECT a FROM UsuarioDTO u RIGHT JOIN AgenciaDTO a ON(u.id = a.id.usuario.id) WHERE u.nombre = :nombre and u.password = :password")
    AgenciaDTO loginAgencia(String nombre, String password);
}
