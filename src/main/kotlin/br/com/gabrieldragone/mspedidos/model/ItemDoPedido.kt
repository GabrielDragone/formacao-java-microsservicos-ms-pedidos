package br.com.gabrieldragone.mspedidos.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

@Entity
@Table(name = "item_do_pedido")
data class ItemDoPedido(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @NotNull
    @Positive
    val quantidade: Int,
    val descricao: String,
    @ManyToOne(optional = false)
    var pedido: Pedido
)