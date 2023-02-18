package com.example.ejercicio_u3_pw_p3_nc.repository;

import com.example.ejercicio_u3_pw_p3_nc.model.Paciente;

public interface IPacienteRepository {
    void insertarPaciente(Paciente paciente);
	Paciente buscarPaciente(Integer id);
	void actualizarPaciente(Paciente paciente);
	void borrarPaciente(Integer id);
    Paciente buscarPacientePorCedula(String cedula);
}
