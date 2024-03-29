package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.PagoDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.PagoPK;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.Services.PagoINF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagoDAO {
    @Autowired
    private PagoINF pagoINF;
    public void deleteById(PagoPK id){
        pagoINF.deleteById(id);
    }
    public Optional<PagoDTO> findById(PagoPK id){
        return pagoINF.findById(id);
    }
    public PagoDTO save(PagoDTO pagoDTO){
        return pagoINF.save(pagoDTO);
    }
    public PagoDTO updateById(PagoPK pagoPK,PagoDTO nuevoPagoDTO){
        pagoINF.deleteById(pagoPK);
        return pagoINF.save(nuevoPagoDTO);
    }
}
