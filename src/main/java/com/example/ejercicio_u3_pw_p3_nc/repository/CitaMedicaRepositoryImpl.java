package com.example.ejercicio_u3_pw_p3_nc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.ejercicio_u3_pw_p3_nc.model.CitaMedica;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {

    @PersistenceContext
	private EntityManager entityManager;
    
    @Override
    public void insertarCitaMedica(CitaMedica citaMedica) {
        // TODO Auto-generated method stub
        this.entityManager.persist(citaMedica);
    }

    @Override
    public CitaMedica buscarCitaMedica(Integer id) {
        // TODO Auto-generated method stub
        return this.entityManager.find(CitaMedica.class, id);
    }

    @Override
    public void actualizarCitaMedica(CitaMedica citaMedica) {
        // TODO Auto-generated method stub
        this.entityManager.merge(citaMedica);
    }

    @Override
    public void borrarCitaMedica(Integer id) {
        // TODO Auto-generated method stub
        this.entityManager.remove(this.buscarCitaMedica(id));
    }

    @Override
    public CitaMedica buscarCitaMedicaPorNumeroDeCita(String numero) {
        // TODO Auto-generated method stub
        TypedQuery<CitaMedica> myQuery = this.entityManager.createQuery("SELECT c FROM CitaMedica c WHERE c.numero =:numero", CitaMedica.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
    }

    @Override
    public List<CitaMedica> citasMedicasPendientes(String cedula) {
        // TODO Auto-generated method stub
        //TypedQuery<CitaMedica> myQuery = this.entityManager.createQuery("SELECT c FROM CitaMedica c JOIN Doctor d ON c.doctor = d WHERE d.cedula =:cedula AND c.receta ISNULL", CitaMedica.class);
		TypedQuery<CitaMedica> myQuery = this.entityManager.createQuery("SELECT c FROM CitaMedica c", CitaMedica.class);
		
        //myQuery.setParameter("cedula", cedula);
        return myQuery.getResultList();
    }
    
}
