package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO.HotelDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HotelINF extends JpaRepository<HotelDTO, Integer> {
    @Query(value = "SELECT * FROM hotel WHERE categoria = CAST(:categoria AS real)", nativeQuery = true)
    Page<HotelDTO> findByCategoria(@Param("categoria") double categoria, Pageable pageable);

    @Query(value = "SELECT * FROM hotel WHERE id_municipio = :id_municipio", nativeQuery = true)
    Page<HotelDTO> findByCity(@Param("id_municipio") int id_municipio, Pageable pageable);

    @Query(value = "SELECT * FROM hotel WHERE id_municipio = :id_municipio AND categoria = :categoria", nativeQuery = true)
    Page<HotelDTO> findByDoubleFilter(@Param("id_municipio") int id_municipio, int categoria, Pageable pageable);
}
