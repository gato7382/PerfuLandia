package com.PerfuLandia.perfulandia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gerente")
public class Gerente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private String sucursal;

    @Transient  // Campo calculado dinámicamente (no se guarda en BD)
    private int cantidadEmpleados;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    @JsonBackReference("admin-gerente")
    private Admin admin;  // Relación con Admin

    @OneToMany(mappedBy = "jefe", cascade = CascadeType.ALL)
    @JsonManagedReference("gerente-empleado")
    private List<Empleado> empleados;  // Un Gerente tiene muchos Empleados
}