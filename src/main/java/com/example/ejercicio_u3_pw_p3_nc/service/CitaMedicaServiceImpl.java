package com.example.ejercicio_u3_pw_p3_nc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejercicio_u3_pw_p3_nc.model.CitaMedica;
import com.example.ejercicio_u3_pw_p3_nc.repository.ICitaMedicaRepository;
import com.example.ejercicio_u3_pw_p3_nc.repository.IDoctorRepository;
import com.example.ejercicio_u3_pw_p3_nc.repository.IPacienteRepository;
import com.example.ejercicio_u3_pw_p3_nc.service.to.CitaMedicaTo;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;
	@Autowired
	private IPacienteRepository pacienteRepository;
	@Autowired
	private IDoctorRepository doctorRepository;
	
	@Override
	public void insertarCitaMedica(CitaMedicaTo citaMedica) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.insertarCitaMedica(this.transform(citaMedica));
	}

	@Override
	public CitaMedicaTo buscarCitaMedica(Integer id) {
		// TODO Auto-generated method stub
		return this.transformTo(this.citaMedicaRepository.buscarCitaMedica(id));
	}

	@Override
	public void actualizarCitaMedica(CitaMedicaTo citaMedica) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.actualizarCitaMedica(this.transform(citaMedica));
	}

	@Override
	public void borrarCitaMedica(Integer id) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.borrarCitaMedica(id);
	}

	@Override
	public CitaMedicaTo buscarCitaMedicaPorNumeroDeCita(String numero) {
		// TODO Auto-generated method stub
		return this.transformTo(this.citaMedicaRepository.buscarCitaMedicaPorNumeroDeCita(numero));
	}

	@Override
	public List<CitaMedicaTo> citasMedicasPendientes(String cedula) {
		// TODO Auto-generated method stub
		return this.citaMedicaRepository.citasMedicasPendientes(cedula).stream().map(cita -> this.transformTo(cita)).collect(Collectors.toList());
	}

	private CitaMedica transform(CitaMedicaTo citaMedicaTo) {
		CitaMedica citaMedica = new CitaMedica();
		citaMedica.setId(citaMedicaTo.getId());
		citaMedica.setNumero(citaMedicaTo.getNumero());
		citaMedica.setFechaCita(citaMedicaTo.getFechaCita());
		citaMedica.setValorCita(citaMedicaTo.getValorCita());
		citaMedica.setLugar(citaMedicaTo.getLugar());
		citaMedica.setDiagnostico(citaMedicaTo.getDiagnostico());
		citaMedica.setReceta(citaMedicaTo.getReceta());
		citaMedica.setFechaProximaCita(citaMedicaTo.getFechaProximaCita());

		citaMedica.setPaciente(this.pacienteRepository.buscarPaciente(citaMedicaTo.getIdPaciente()));
		citaMedica.setDoctor(this.doctorRepository.buscarDoctor(citaMedicaTo.getIdDoctor()));

		return citaMedica;
	}

	private CitaMedicaTo transformTo(CitaMedica citaMedica) {
		CitaMedicaTo citaMedicaTo = new CitaMedicaTo();
		citaMedicaTo.setId(citaMedica.getId());
		citaMedicaTo.setNumero(citaMedica.getNumero());
		citaMedicaTo.setFechaCita(citaMedica.getFechaCita());
		citaMedicaTo.setValorCita(citaMedica.getValorCita());
		citaMedicaTo.setLugar(citaMedica.getLugar());
		citaMedicaTo.setDiagnostico(citaMedica.getDiagnostico());
		citaMedicaTo.setReceta(citaMedica.getReceta());
		citaMedicaTo.setFechaProximaCita(citaMedica.getFechaProximaCita());

		citaMedicaTo.setIdPaciente(citaMedica.getPaciente().getId());
		citaMedicaTo.setIdDoctor(citaMedica.getDoctor().getId());

		return citaMedicaTo;
	}
}
