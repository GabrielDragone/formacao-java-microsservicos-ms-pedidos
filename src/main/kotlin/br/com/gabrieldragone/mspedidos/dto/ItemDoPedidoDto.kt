package br.com.gabrieldragone.mspedidos.dto

data class ItemDoPedidoDto (
    var id: Long? = null,
    var quantidade: Int? = null,
    var descricao: String? = null
)