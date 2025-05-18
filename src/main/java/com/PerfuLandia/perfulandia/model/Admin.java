package com.PerfuLandia.perfulandia.model;

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
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String contraseña;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    @JsonManagedReference("admin-gerente")
    private List<Gerente> gerentes;  // Un Admin gestiona muchos Gerentes

}