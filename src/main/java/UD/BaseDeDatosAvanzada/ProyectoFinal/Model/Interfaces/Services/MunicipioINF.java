package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.Interfaces.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import UD.BaseDeDatosAvanzada.ProyectoFinal.Model.BD.DTO.MunicipioDTO;
public interface MunicipioINF extends JpaRepository<MunicipioDTO, Integer> { }
