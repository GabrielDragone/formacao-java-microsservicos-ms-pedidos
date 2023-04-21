package br.com.gabrieldragone.mspedidos.model

import br.com.gabrieldragone.mspedidos.enum.Status
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

@Entity
@Table(name = "pedidos")
data class Pedido (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @NotNull
    var dataHora: LocalDateTime = LocalDateTime.now(),
    @NotNull @Enumerated(EnumType.STRING)
    var status: Status,
    @OneToMany(cascade = arrayOf(CascadeType.PERSIST), mappedBy = "pedido")
    var itens: List<ItemDoPedido> = emptyList()
)