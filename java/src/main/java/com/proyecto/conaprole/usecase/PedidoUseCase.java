package com.proyecto.conaprole.usecase;

import com.proyecto.conaprole.entity.Pedido;
import com.proyecto.conaprole.infraestructure.ingoing.dtos.CrearPedidoDTO;

public interface PedidoUseCase {
    Pedido save(CrearPedidoDTO crearPedidoDTO);
}
