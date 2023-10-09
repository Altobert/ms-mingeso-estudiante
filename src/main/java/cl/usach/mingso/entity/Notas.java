package cl.usach.mingso.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Notas {
	
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String rut;
    private LocalDate fecha_examen;
    private int puntaje;
}
