package com.PerfuLandia.perfulandia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String contraseña;

    @Column(nullable = false, unique = true)
    private String codigoEmpleado;  // Ej: "EMP-001"

    @ManyToOne
    @JoinColumn(name = "gerente_id", nullable = false)
    @JsonBackReference("gerente-empleado")
    private Gerente jefe;  // Relación con Gerente
}