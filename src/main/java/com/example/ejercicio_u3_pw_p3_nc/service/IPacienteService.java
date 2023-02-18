package com.example.ejercicio_u3_pw_p3_nc.service;

import com.example.ejercicio_u3_pw_p3_nc.model.Paciente;
import com.example.ejercicio_u3_pw_p3_nc.service.to.PacienteTo;

public interface IPacienteService {
    void insertarPaciente(PacienteTo paciente);
	PacienteTo buscarPaciente(Integer id);
	void actualizarPaciente(Paciente paciente);
	void borrarPaciente(Integer id);
    PacienteTo buscarPacientePorCedula(String cedula);
}
