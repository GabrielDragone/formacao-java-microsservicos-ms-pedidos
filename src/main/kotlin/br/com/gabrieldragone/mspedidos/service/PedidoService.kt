package br.com.gabrieldragone.mspedidos.service

import br.com.gabrieldragone.mspedidos.dto.PedidoDto
import br.com.gabrieldragone.mspedidos.dto.StatusDto
import br.com.gabrieldragone.mspedidos.enum.Status
import br.com.gabrieldragone.mspedidos.model.Pedido
import br.com.gabrieldragone.mspedidos.repository.PedidoRepository
import jakarta.persistence.EntityNotFoundException
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.stream.Collectors

@Service
class PedidoService(
    private val pedidoRepository: PedidoRepository,
    private val modelMapper: ModelMapper) {

    fun obterTodos(): List<PedidoDto> {
        return pedidoRepository
            .findAll()
            .stream()
            .map {
                cadaPedido -> modelMapper.map(cadaPedido, PedidoDto::class.java)
            }.collect(Collectors.toList())
    }

    fun obterPorId(id: Long): PedidoDto {
        val pedido = pedidoRepository.findById(id).orElseThrow { EntityNotFoundException("Entidade não encontrada") }
        return modelMapper.map(pedido, PedidoDto::class.java)
    }

    fun criarPedido(dto: PedidoDto): PedidoDto {
        var novoPedido = modelMapper.map(dto, Pedido::class.java)

        novoPedido.dataHora = LocalDateTime.now()
        novoPedido.status = Status.REALIZADO
        novoPedido.itens.forEach{
            item -> item.pedido = novoPedido
        }
        novoPedido = pedidoRepository.save(novoPedido)

        return modelMapper.map(novoPedido, PedidoDto::class.java)
    }

    fun atualizarStatus(id: Long, dto: StatusDto): PedidoDto {
        val pedido = pedidoRepository.buscarPorIdComItens(id)

        if (pedido == null) {
            throw EntityNotFoundException("Entidade não encontrada")
        }

        pedido.status = dto.status
        pedidoRepository.atualizarStatus(dto.status, pedido)
        return modelMapper.map(pedido, PedidoDto::class.java)
    }

    fun aprovarPagamentoPedido(id: Long) {
        val statusPagoDto = StatusDto(status = Status.PAGO)
        atualizarStatus(id, statusPagoDto)
    }

}
