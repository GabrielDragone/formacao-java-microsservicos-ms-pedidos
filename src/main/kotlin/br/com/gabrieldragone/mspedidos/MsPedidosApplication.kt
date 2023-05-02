package br.com.gabrieldragone.mspedidos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
//@EnableDiscoveryClient // Aplicação é um Cliente Eureka e deverá se registrar ao Eureka Server
class MsPedidosApplication

fun main(args: Array<String>) {
	runApplication<MsPedidosApplication>(*args)
}
