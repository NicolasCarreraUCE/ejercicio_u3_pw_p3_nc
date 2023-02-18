package com.example.ejercicio_u3_pw_p3_nc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejercicio_u3_pw_p3_nc.service.IDoctorService;
import com.example.ejercicio_u3_pw_p3_nc.service.to.DoctorTo;

@RestController
@Controller("/doctor")
public class DoctorControllerRestFull {
    
    @Autowired
    private IDoctorService doctorService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertarDoctor(@RequestBody DoctorTo doctor) {
        this.doctorService.insertarDoctor(doctor);
    }

    public Class<?> buscarDoctor(Integer idDoctor) {
        return null;
    }
}
