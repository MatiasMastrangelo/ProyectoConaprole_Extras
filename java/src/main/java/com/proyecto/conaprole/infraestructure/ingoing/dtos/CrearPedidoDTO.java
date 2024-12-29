package com.proyecto.conaprole.infraestructure.ingoing.dtos;

import java.util.List;

public record CrearPedidoDTO(String fecha, List<CrearLineaPedidoDTO> lineas) {
}
