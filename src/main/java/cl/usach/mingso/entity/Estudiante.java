package cl.usach.mingso.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "estudiantes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Estudiante {
	
    @Id    
    private String rut;
    private String nombres;
    private String apellidos;
    private LocalDate fecha_nacimiento;
    private int tipo_colegio;
    private String nombre_colegio;
    private LocalDate anio_egreso;
    private LocalDate anio_ingreso;
    
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public int getTipo_colegio() {
		return tipo_colegio;
	}
	public void setTipo_colegio(int tipo_colegio) {
		this.tipo_colegio = tipo_colegio;
	}
	public String getNombre_colegio() {
		return nombre_colegio;
	}
	public void setNombre_colegio(String nombre_colegio) {
		this.nombre_colegio = nombre_colegio;
	}
	public LocalDate getAnio_egreso() {
		return anio_egreso;
	}
	public void setAnio_egreso(LocalDate anio_egreso) {
		this.anio_egreso = anio_egreso;
	}
	public LocalDate getAnio_ingreso() {
		return anio_ingreso;
	}
	public void setAnio_ingreso(LocalDate anio_ingreso) {
		this.anio_ingreso = anio_ingreso;
	}
}
