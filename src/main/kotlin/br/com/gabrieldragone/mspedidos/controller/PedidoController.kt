package br.com.gabrieldragone.mspedidos.controller

import br.com.gabrieldragone.mspedidos.dto.PedidoDto
import br.com.gabrieldragone.mspedidos.dto.StatusDto
import br.com.gabrieldragone.mspedidos.service.PedidoService
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/v1/pedidos")
class PedidoController(private val pedidoService: PedidoService) {

    @GetMapping
    fun listarTodos(): List<PedidoDto> {
        return pedidoService.obterTodos()
    }

    @GetMapping("/{id}")
    fun obterPorId(@PathVariable @NotNull id: Long): ResponseEntity<PedidoDto> {
        return ResponseEntity.ok(pedidoService.obterPorId(id))
    }

    @PostMapping
    fun realizarPedido(@RequestBody @Valid dto: PedidoDto, uriBuilder: UriComponentsBuilder): ResponseEntity<PedidoDto> {
        val pedidoRealizado = pedidoService.criarPedido(dto)

        val endereco = uriBuilder.path("/api/v1/pedidos/{id}").buildAndExpand(pedidoRealizado.id).toUri()

        return ResponseEntity.created(endereco).body(pedidoRealizado)
    }

    @PutMapping("/{id}/atualizar-status")
    fun atualizarStatus(@PathVariable id: Long, @RequestBody statusDto: StatusDto): ResponseEntity<PedidoDto> {
        val dto = pedidoService.atualizarStatus(id, statusDto)
        return ResponseEntity.ok(dto)
    }

    @PutMapping("/{id}/aprovar-pagamento")
    fun aprovarPagamento(@PathVariable @NotNull id: Long): ResponseEntity<Unit> {
        pedidoService.aprovarPagamentoPedido(id)
        return ResponseEntity.ok().build()
    }

}