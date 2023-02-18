package com.example.ejercicio_u3_pw_p3_nc.service;

import com.example.ejercicio_u3_pw_p3_nc.model.Doctor;
import com.example.ejercicio_u3_pw_p3_nc.service.to.DoctorTo;

public interface IDoctorService {
    void insertarDoctor(DoctorTo doctor);
	DoctorTo buscarDoctor(Integer id);
	void actualizarDoctor(Doctor doctor);
	void borrarDoctor(Integer id);
    Doctor buscarDoctorPorCedula(String doctor);
}
