package com.PerfuLandia.perfulandia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "empleado")
@NoArgsConstructor
@AllArgsConstructor

public class EmpleadoVentas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int ventas;

    @Column(nullable = false)
    private String inventario;

}
