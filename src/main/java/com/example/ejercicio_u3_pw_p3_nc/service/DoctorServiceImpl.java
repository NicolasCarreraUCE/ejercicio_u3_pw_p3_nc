package com.example.ejercicio_u3_pw_p3_nc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejercicio_u3_pw_p3_nc.model.Doctor;
import com.example.ejercicio_u3_pw_p3_nc.repository.IDoctorRepository;
import com.example.ejercicio_u3_pw_p3_nc.service.to.DoctorTo;

@Service
public class DoctorServiceImpl implements IDoctorService {
    
    @Autowired
	private IDoctorRepository doctorRepository;
	
	@Override
	public void insertarDoctor(DoctorTo doctor) {
		// TODO Auto-generated method stub
		this.doctorRepository.insertarDoctor(this.transform(doctor));
	}

	@Override
	public DoctorTo buscarDoctor(Integer id) {
		// TODO Auto-generated method stub
		return this.transformTo(this.doctorRepository.buscarDoctor(id));
	}

	@Override
	public void actualizarDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.doctorRepository.actualizarDoctor(doctor);
	}

	@Override
	public void borrarDoctor(Integer id) {
		// TODO Auto-generated method stub
		this.doctorRepository.borrarDoctor(id);
	}

	@Override
	public Doctor buscarDoctorPorCedula(String doctor) {
		// TODO Auto-generated method stub
		return this.doctorRepository.buscarDoctorPorCedula(doctor);
	}

	private Doctor transform(DoctorTo doctorTo) {
		Doctor doctor = new Doctor();
		doctor.setId(doctorTo.getId());
		doctor.setCedula(doctorTo.getCedula());
		doctor.setNombre(doctorTo.getNombre());
		doctor.setApellido(doctorTo.getApellido());
		doctor.setFechaNacimiento(doctorTo.getFechaNacimiento());
		doctor.setNumeroConsultorio(doctorTo.getNumeroConsultorio());
		doctor.setGenero(doctorTo.getGenero());

		return doctor;
	}

	private DoctorTo transformTo(Doctor doctor) {
		DoctorTo doctorTo = new DoctorTo();
		doctorTo.setId(doctor.getId());
		doctorTo.setCedula(doctor.getCedula());
		doctorTo.setNombre(doctor.getNombre());
		doctorTo.setApellido(doctor.getApellido());
		doctorTo.setFechaNacimiento(doctor.getFechaNacimiento());
		doctorTo.setNumeroConsultorio(doctor.getNumeroConsultorio());
		doctorTo.setGenero(doctor.getGenero());

		return doctorTo;
	}
}
