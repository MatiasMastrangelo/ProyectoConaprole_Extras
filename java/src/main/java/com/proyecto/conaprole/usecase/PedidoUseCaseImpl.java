package com.proyecto.conaprole.usecase;

import com.proyecto.conaprole.entity.LineaPedido;
import com.proyecto.conaprole.entity.Pedido;
import com.proyecto.conaprole.infraestructure.ingoing.dtos.CrearPedidoDTO;
import com.proyecto.conaprole.repository.PedidoRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PedidoUseCaseImpl implements PedidoUseCase {

    private final PedidoRepository pedidoRepository;

    public PedidoUseCaseImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido save(CrearPedidoDTO crearPedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setFecha(crearPedidoDTO.fecha());
        pedido.setLineas(
                crearPedidoDTO.lineas().stream()
                        .map(linea -> {
                            LineaPedido lineaPedido = new LineaPedido();
                            lineaPedido.setPedido(pedido);
                            lineaPedido.setCantidad(linea.cantidad());
                            lineaPedido.setProducto(linea.producto());
                            return lineaPedido;

                        })
                        .collect(Collectors.toList())
        );

        // Guardar el pedido en la base de datos
        return pedidoRepository.save(pedido);
    }

}
