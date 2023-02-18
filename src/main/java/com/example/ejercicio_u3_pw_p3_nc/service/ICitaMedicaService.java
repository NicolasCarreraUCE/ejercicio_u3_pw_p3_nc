package com.example.ejercicio_u3_pw_p3_nc.service;

import java.util.List;

import com.example.ejercicio_u3_pw_p3_nc.service.to.CitaMedicaTo;

public interface ICitaMedicaService {
    void insertarCitaMedica(CitaMedicaTo citaMedica);
	CitaMedicaTo buscarCitaMedica(Integer id);
	void actualizarCitaMedica(CitaMedicaTo citaMedica);
	void borrarCitaMedica(Integer id);
    CitaMedicaTo buscarCitaMedicaPorNumeroDeCita(String numero);
    List<CitaMedicaTo> citasMedicasPendientes(String cedula);
}
