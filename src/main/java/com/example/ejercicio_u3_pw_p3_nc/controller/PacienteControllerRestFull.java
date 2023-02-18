package com.example.ejercicio_u3_pw_p3_nc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejercicio_u3_pw_p3_nc.service.IPacienteService;
import com.example.ejercicio_u3_pw_p3_nc.service.to.PacienteTo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller("/paciente")
@RestController
public class PacienteControllerRestFull {
    
    @Autowired
    private IPacienteService pacienteService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertaPaciente(@RequestBody PacienteTo pacienteTo) {
        Link link = linkTo(methodOn(PacienteControllerRestFull.class).buscarPaciente(pacienteTo.getId())).withSelfRel();
		pacienteTo.add(link);

        this.pacienteService.insertarPaciente(pacienteTo);    
    }

    @GetMapping
    public PacienteTo buscarPacientePorCedula(String cedula) {
        return this.pacienteService.buscarPacientePorCedula(cedula);
    }

    @GetMapping
    public PacienteTo buscarPaciente(Integer id) {
        return this.pacienteService.buscarPaciente(id);
    }
}
