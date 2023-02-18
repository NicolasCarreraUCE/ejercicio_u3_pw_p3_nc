package com.example.ejercicio_u3_pw_p3_nc.repository;

import org.springframework.stereotype.Repository;

import com.example.ejercicio_u3_pw_p3_nc.model.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {
    
    @PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
	}

	@Override
	public Paciente buscarPaciente(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public void borrarPaciente(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPaciente(id));
	}

	@Override
	public Paciente buscarPacientePorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Paciente> myQuery = this.entityManager.createQuery("SELECT p FROM Paciente p WHERE p.cedula =:cedula", Paciente.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

}
