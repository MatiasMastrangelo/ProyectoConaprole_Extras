package com.proyecto.conaprole.infraestructure.ingoing.dtos;

import lombok.Builder;

@Builder
public record PedidoDTO(String id, String date, Double total) {

}
