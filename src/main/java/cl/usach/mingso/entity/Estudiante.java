package cl.usach.mingso.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estudiante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {
	
	@EmbeddedId	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "rut")
	private Integer rut; 
	 
	@Column(name = "apellidos")
	private String apellidos;
	 
	@Column(name = "nombres")
	private String nombres;
	 
	@Column(name = "fcnacimiento")
	private String fechaNacimiento;
	 
	@Column(name = "tipocolegio")
	private String tipoColegio;
	 
	@Column(name = "nombrecolegio")
	private String nombreColegio;
	
	@Column(name = "añoegreso")
	private Integer añoEgresoColegio;

}
