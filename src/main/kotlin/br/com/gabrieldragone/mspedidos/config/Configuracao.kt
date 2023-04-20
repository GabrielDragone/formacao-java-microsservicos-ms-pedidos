package br.com.gabrieldragone.mspedidos.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Configuracao {

    @Bean
    fun getModelMapper(): ModelMapper {
        return ModelMapper()
    }

}