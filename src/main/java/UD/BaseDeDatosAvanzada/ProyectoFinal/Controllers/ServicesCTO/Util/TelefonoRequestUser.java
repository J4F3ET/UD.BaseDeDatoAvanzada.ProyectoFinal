package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.ServicesCTO.Util;

import java.util.Collection;
import java.util.List;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.Telefono_UsuarioDTO;

public class TelefonoRequestUser {
    private Collection<Telefono_UsuarioDTO> telefonos;

    public Collection<Telefono_UsuarioDTO> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Collection<Telefono_UsuarioDTO> telefonos) {
        this.telefonos = telefonos;
    }
    @Override
    public String toString() {
        String response = "TelefonoRequestUser{";
        this.telefonos.forEach(telefono -> {
            response.concat(telefono.toString());
        });
        response.concat("}");
        return response;
    }
}
