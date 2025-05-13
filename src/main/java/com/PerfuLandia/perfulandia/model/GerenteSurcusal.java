package com.PerfuLandia.perfulandia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "gerentesurcusal")
@NoArgsConstructor
@AllArgsConstructor
public class GerenteSurcusal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int inventario;

    @Column(nullable = false)
    private String reportes;

    @Column(nullable = false)
    private String sucursal;

    @Column(nullable = false)
    private int pedidos;

}
