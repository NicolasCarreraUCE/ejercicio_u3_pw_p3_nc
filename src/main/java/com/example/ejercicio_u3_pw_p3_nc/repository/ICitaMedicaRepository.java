package com.example.ejercicio_u3_pw_p3_nc.repository;

import java.util.List;

import com.example.ejercicio_u3_pw_p3_nc.model.CitaMedica;


public interface ICitaMedicaRepository {
    void insertarCitaMedica(CitaMedica citaMedica);
	CitaMedica buscarCitaMedica(Integer id);
	void actualizarCitaMedica(CitaMedica citaMedica);
	void borrarCitaMedica(Integer id);
    CitaMedica buscarCitaMedicaPorNumeroDeCita(String numero);
    List<CitaMedica> citasMedicasPendientes(String cedula);
}
