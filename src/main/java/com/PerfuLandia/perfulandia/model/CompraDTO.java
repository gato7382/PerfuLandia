package com.PerfuLandia.perfulandia.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraDTO {
    private int productoId;
    private int clienteId;
    private int cantidad;
}