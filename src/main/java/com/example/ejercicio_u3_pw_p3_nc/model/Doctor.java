package com.example.ejercicio_u3_pw_p3_nc.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
    
    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_doctor", sequenceName = "seq_doctor", allocationSize = 1)
	@Column(name = "doct_id")
    private Integer id;

    @Column(name = "doct_cedula")
	private String cedula;
	@Column(name = "doct_nombre")
	private String nombre;
	@Column(name = "doct_apellido")
	private String apellido;
	@Column(name = "doct_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	@Column(name = "doct_numero_consultorio")
	private String numeroConsultorio;
	@Column(name = "doct_genero")
	private String genero;
	
	@OneToMany(mappedBy = "doctor")
	private List<CitaMedica> citaMedicas;

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
    public List<CitaMedica> getCitaMedicas() {
        return citaMedicas;
    }
    public void setCitaMedicas(List<CitaMedica> citaMedicas) {
        this.citaMedicas = citaMedicas;
    }
    
}
