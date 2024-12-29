package com.proyecto.conaprole.infraestructure.ingoing;

import com.proyecto.conaprole.infraestructure.ingoing.dtos.CrearPedidoDTO;
import com.proyecto.conaprole.infraestructure.ingoing.dtos.PedidoDTO;
import com.proyecto.conaprole.usecase.PedidoUseCase;
import com.proyecto.conaprole.usecase.PedidoUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidosController {

    @Autowired
    private final PedidoUseCase pedidoUseCase;

    public PedidosController(PedidoUseCase pedidoUseCase) {
        this.pedidoUseCase = pedidoUseCase;
    }

    @PostMapping("/pedido")
    public ResponseEntity<PedidoDTO> CrearPedido(@RequestBody CrearPedidoDTO crearPedido) throws InterruptedException {
        PedidoDTO pedido = PedidoDTO.builder()
                .id("12345")
                .date(crearPedido.fecha())
                .total(150.75)
                .build();

        pedidoUseCase.save(crearPedido);
        Thread.sleep(1500);
        return ResponseEntity.ok(pedido);
    }

}
