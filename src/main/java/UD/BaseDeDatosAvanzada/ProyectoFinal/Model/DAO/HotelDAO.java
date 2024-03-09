package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DAO;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.HotelDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.DTO.IHotelPublicDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.Services.HotelINF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class HotelDAO {
    @Autowired
    private HotelINF hotelINF;

    public void deleteById(int id) {
        hotelINF.deleteById(id);
    }

    public HotelDTO save(HotelDTO hotelDTO) {
        return hotelINF.save(hotelDTO);
    }

    public Optional<HotelDTO> findById(int id) {
        return hotelINF.findById(id);
    }

    public Iterable<IHotelPublicDTO> findAllHotelProjection(int pageNumber) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<IHotelPublicDTO> page = hotelINF.findAllHotelProjection(pageable);
        return page.getContent();
    }

    public Iterable<IHotelPublicDTO> findByCity(int pageNumber, int id_municipio) {
        int pageSize = 10;
        Sort sort = Sort.by(Sort.Direction.ASC, "nombre");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<IHotelPublicDTO> page = hotelINF.findByCity(id_municipio, pageable);
        return page.getContent();
    }

    public Iterable<IHotelPublicDTO> findByCategoria(int pageNumber, int categoria) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<IHotelPublicDTO> page = hotelINF.findByCategoria(categoria, pageable);
        return page.getContent();
    }

    public Iterable<IHotelPublicDTO> findByDoubleFilter(int pageNumber, int id_municipio, int categoria) {
        int pageSize = 10;
        Sort sort = Sort.by(Sort.Direction.ASC, "nombre");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<IHotelPublicDTO> page = hotelINF.findByDoubleFilter(id_municipio, categoria, pageable);
        return page.getContent();
    }

    public HotelDTO update(int id, HotelDTO hotelDTO) {
        hotelINF.deleteById(id);
        return hotelINF.save(hotelDTO);
    }

}
