package com.PerfuLandia.perfulandia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor


public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombreProducto;

    @Column(nullable = false)
    private int cantidadStock;

    @Column(nullable = false)
    private double precio;

}
