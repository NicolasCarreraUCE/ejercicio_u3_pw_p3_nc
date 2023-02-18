package com.example.ejercicio_u3_pw_p3_nc.repository;

import com.example.ejercicio_u3_pw_p3_nc.model.Doctor;

public interface IDoctorRepository {
    void insertarDoctor(Doctor doctor);
	Doctor buscarDoctor(Integer id);
	void actualizarDoctor(Doctor doctor);
	void borrarDoctor(Integer id);
    Doctor buscarDoctorPorCedula(String doctor);
}
