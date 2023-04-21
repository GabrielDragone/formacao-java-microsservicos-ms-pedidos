package br.com.gabrieldragone.mspedidos.dto

import br.com.gabrieldragone.mspedidos.enum.Status
import java.time.LocalDateTime

data class PedidoDto(
    var id: Long? = null,
    var dataHora: LocalDateTime = LocalDateTime.now(),
    var status: Status? = Status.REALIZADO,
    var itens: List<ItemDoPedidoDto> = emptyList()
)
