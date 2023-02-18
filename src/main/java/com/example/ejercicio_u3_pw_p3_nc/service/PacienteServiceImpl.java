package com.example.ejercicio_u3_pw_p3_nc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejercicio_u3_pw_p3_nc.model.Paciente;
import com.example.ejercicio_u3_pw_p3_nc.repository.IPacienteRepository;
import com.example.ejercicio_u3_pw_p3_nc.service.to.PacienteTo;


@Service
public class PacienteServiceImpl implements IPacienteService {
    
    @Autowired
	private IPacienteRepository pacienteRepository;
	
	@Override
	public void insertarPaciente(PacienteTo paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepository.insertarPaciente(this.transform(paciente));
	}

	@Override
	public PacienteTo buscarPaciente(Integer id) {
		// TODO Auto-generated method stub
		return this.transformTo(this.pacienteRepository.buscarPaciente(id));
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepository.actualizarPaciente(paciente);
	}

	@Override
	public void borrarPaciente(Integer id) {
		// TODO Auto-generated method stub
		this.pacienteRepository.borrarPaciente(id);
	}

	@Override
	public PacienteTo buscarPacientePorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.transformTo(this.pacienteRepository.buscarPacientePorCedula(cedula));
	}

	private Paciente transform(PacienteTo pacienteTo) {
		Paciente paciente = new Paciente();
		paciente.setId(pacienteTo.getId());
		paciente.setCedula(pacienteTo.getCedula());
		paciente.setNombre(pacienteTo.getNombre());
		paciente.setApellido(pacienteTo.getApellido());
		paciente.setFechaNacimiento(pacienteTo.getFechaNacimiento());
		paciente.setCodigoSeguro(pacienteTo.getCodigoSeguro());
		paciente.setEstatura(pacienteTo.getEstatura());
		paciente.setPeso(pacienteTo.getPeso());
		paciente.setGenero(pacienteTo.getGenero());

		return paciente;
	}

	private PacienteTo transformTo(Paciente paciente) {
		PacienteTo pacienteTo = new PacienteTo();
		pacienteTo.setId(paciente.getId());
		pacienteTo.setCedula(paciente.getCedula());
		pacienteTo.setNombre(paciente.getNombre());
		pacienteTo.setApellido(paciente.getApellido());
		pacienteTo.setFechaNacimiento(paciente.getFechaNacimiento());
		pacienteTo.setCodigoSeguro(paciente.getCodigoSeguro());
		pacienteTo.setEstatura(paciente.getEstatura());
		pacienteTo.setPeso(paciente.getPeso());
		pacienteTo.setGenero(paciente.getGenero());

		return pacienteTo;
	}
}
