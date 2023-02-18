package com.example.ejercicio_u3_pw_p3_nc.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejercicio_u3_pw_p3_nc.service.ICitaMedicaService;
import com.example.ejercicio_u3_pw_p3_nc.service.IDoctorService;
import com.example.ejercicio_u3_pw_p3_nc.service.IPacienteService;
import com.example.ejercicio_u3_pw_p3_nc.service.to.CitaMedicaTo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/cita_medica")
public class CitaMedicaControllerRestFull {
    
    @Autowired
    private ICitaMedicaService citaMedicaService;
    @Autowired
    private IDoctorService doctorService;
    @Autowired
    private IPacienteService pacienteService;

    @PutMapping(path = "/agendar-cita")
    public void agendarCitaMedica(@RequestParam String numero, @RequestParam LocalDateTime fecha, @RequestParam BigDecimal valor, @RequestParam String lugar, @RequestParam String doctor, @RequestParam String paciente) {
        CitaMedicaTo citaMedica = new CitaMedicaTo();
        citaMedica.setNumero(numero);
        citaMedica.setFechaCita(fecha);
        citaMedica.setValorCita(valor);
        citaMedica.setLugar(lugar);
        citaMedica.setIdDoctor(this.doctorService.buscarDoctorPorCedula(doctor).getId());
        citaMedica.setIdPaciente(this.pacienteService.buscarPacientePorCedula(paciente).getId());
        
        Link linDoctor = linkTo(methodOn(DoctorControllerRestFull.class).buscarDoctor(citaMedica.getIdDoctor())).withSelfRel();
		citaMedica.add(linDoctor);
        
        Link linPaciente = linkTo(methodOn(PacienteControllerRestFull.class).buscarPaciente(citaMedica.getIdPaciente())).withSelfRel();
		citaMedica.add(linPaciente);
        
        this.citaMedicaService.insertarCitaMedica(citaMedica);
    }

    @PutMapping(path = "/actualizar_cita")
    public void actualizarCitaMedica(@RequestParam String numero, @RequestParam String diagnostico, @RequestParam String receta, @RequestParam LocalDateTime fecha) {
        CitaMedicaTo citaMedica = this.citaMedicaService.buscarCitaMedicaPorNumeroDeCita(numero);
        citaMedica.setDiagnostico(diagnostico);
        citaMedica.setReceta(receta);
        citaMedica.setFechaProximaCita(fecha);

        this.citaMedicaService.actualizarCitaMedica(citaMedica);
    }

}
