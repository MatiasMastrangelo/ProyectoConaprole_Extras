package com.proyecto.conaprole.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedidos") // Opcional: especifica un nombre para la tabla en la base de datos
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente el ID
    private Long id;

    @Column(nullable = false)
    private String fecha;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<LineaPedido> lineas;

}
