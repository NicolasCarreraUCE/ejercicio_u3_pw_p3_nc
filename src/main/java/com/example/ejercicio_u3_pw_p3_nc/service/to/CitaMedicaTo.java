package com.example.ejercicio_u3_pw_p3_nc.service.to;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

public class CitaMedicaTo extends RepresentationModel<CitaMedicaTo> {
    
    private Integer id;
    private String numero;
	private LocalDateTime fechaCita;
	private BigDecimal valorCita;
	private String lugar;
	private String diagnostico;
	private String receta;
	private LocalDateTime fechaProximaCita;
	
	private Integer idPaciente;
	private Integer idDoctor;

    // SET-GET
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public LocalDateTime getFechaCita() {
        return fechaCita;
    }
    public void setFechaCita(LocalDateTime fechaCita) {
        this.fechaCita = fechaCita;
    }
    public BigDecimal getValorCita() {
        return valorCita;
    }
    public void setValorCita(BigDecimal valorCita) {
        this.valorCita = valorCita;
    }
    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getReceta() {
        return receta;
    }
    public void setReceta(String receta) {
        this.receta = receta;
    }
    public LocalDateTime getFechaProximaCita() {
        return fechaProximaCita;
    }
    public void setFechaProximaCita(LocalDateTime fechaProximaCita) {
        this.fechaProximaCita = fechaProximaCita;
    }
    public Integer getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }
    public Integer getIdDoctor() {
        return idDoctor;
    }
    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

}
