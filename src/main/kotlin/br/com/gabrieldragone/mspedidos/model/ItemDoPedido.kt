package br.com.gabrieldragone.mspedidos.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

@Entity
@Table(name = "item_do_pedido")
data class ItemDoPedido(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @NotNull
    @Positive
    var quantidade: Int,
    var descricao: String,
    @ManyToOne(optional = false)
    var pedido: Pedido
)