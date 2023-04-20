package br.com.gabrieldragone.mspedidos.repository

import br.com.gabrieldragone.mspedidos.enum.Status
import br.com.gabrieldragone.mspedidos.model.Pedido
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface PedidoRepository: JpaRepository<Pedido, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Pedido p SET p.status = :status WHERE p = :pedido")
    fun atualizarStatus(status: Status, pedido: Pedido)

    @Query(value = "SELECT p from Pedido p LEFT JOIN FETCH p.itens WHERE p.id = :id")
    fun buscarPorIdComItens(id: Long): Pedido?

}
