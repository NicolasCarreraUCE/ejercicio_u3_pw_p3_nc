package com.example.ejercicio_u3_pw_p3_nc.service.to;

import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

public class DoctorTo extends RepresentationModel<DoctorTo>{
    
    private Integer id;

    private String cedula;
	private String nombre;
	private String apellido;
	private LocalDateTime fechaNacimiento;
	private String numeroConsultorio;
	private String genero;
	
    // SET-GET
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getNumeroConsultorio() {
        return numeroConsultorio;
    }
    public void setNumeroConsultorio(String numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
