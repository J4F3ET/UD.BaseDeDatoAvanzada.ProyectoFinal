package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.HotelDTO;
import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.DTO.IHotelPublicDTO;

public interface HotelINF extends JpaRepository<HotelDTO, Integer> {

    @Query(value = "SELECT nombre,categoria FROM hotel", nativeQuery = true)
    Page<IHotelPublicDTO> findAllHotelProjection(Pageable pageable);

    @Query(value = "SELECT nombre,categoria FROM hotel WHERE categoria = CAST(:categoria AS real)", nativeQuery = true)
    Page<IHotelPublicDTO> findByCategoria(@Param("categoria") double categoria, Pageable pageable);

    @Query(value = "SELECT nombre,categoria FROM hotel WHERE id_municipio = :id_municipio", nativeQuery = true)
    Page<IHotelPublicDTO> findByCity(@Param("id_municipio") int id_municipio, Pageable pageable);

    @Query(value = "SELECT nombre,categoria FROM hotel WHERE id_municipio = :id_municipio AND categoria = :categoria", nativeQuery = true)
    Page<IHotelPublicDTO> findByDoubleFilter(@Param("id_municipio") int id_municipio, int categoria, Pageable pageable);

}
