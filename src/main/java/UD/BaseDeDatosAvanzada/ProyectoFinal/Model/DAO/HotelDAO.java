package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Interfaces.HotelINF;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.HotelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class HotelDAO {
    @Autowired
    private HotelINF hotelINF;
    public void deleteById(int id){
        hotelINF.deleteById(id);
    }
    public HotelDTO save(HotelDTO hotelDTO){
        return hotelINF.save(hotelDTO);
    }
    public Optional<HotelDTO> findById(int id){
        return hotelINF.findById(id);
    }
    public Iterable<HotelDTO> findAll(int pageNumber){
        int pageSize = 20;
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<HotelDTO> page = hotelINF.findAll(pageable);
        return new ArrayList<>(page.getContent());
    }
    public Iterable<HotelDTO>findByCategoria(int pageNumber,double categoria){
        int pageSize = 20;
        Sort sort = Sort.by(Sort.Direction.ASC, "categoria");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<HotelDTO> page = hotelINF.findByCategoria(categoria,pageable);
        return page.getContent();
    }
    public HotelDTO update(int id,HotelDTO hotelDTO){
        hotelINF.deleteById(id);
        return hotelINF.save(hotelDTO);
    }

}
