package br.com.gabrieldragone.mspedidos.dto

import br.com.gabrieldragone.mspedidos.enum.Status
import java.time.LocalDateTime

data class PedidoDto(
    val id: Long,
    val dataHora: LocalDateTime,
    val status: Status,
    val itens: List<ItemDoPedidoDto> = emptyList()
)
