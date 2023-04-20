# Formação Aprofunde em Java com arquitetura de Microsserviços, Spring e RabbitMQ:
Curso alura: https://cursos.alura.com.br/formacao-java-microsservicos

Projeto e anotações referentes à formação "Aprofunde em Java com arquitetura de Microsserviços, Spring e RabbitMQ".

Microsserviço de Pedidos, funcionária junto com o de Pagamentos e MS Eureka Server.

Esse foi criado do Zero usando Kotlin e Gradle pra treinar, mas com base no MS disponibilizado no curso acima.

Ler as anotações abaixo para mais detalhes:
https://github.com/GabrielDragone/formacao-java-microsservicos-ms-pagamentos

---

## Para rodar a aplicação:
* Abrir o Docker Desktop.
* Rodar o comando para subir o container postgres: docker-compose up.
* Rodar a aplicação através da [MsPedidosApplication.kt](src%2Fmain%2Fkotlin%2Fbr%2Fcom%2Fgabrieldragone%2Fmspedidos%2FMsPedidosApplication.kt).
* Acessar o swagger pra fazer as requisições: http://localhost:{{portaDefinidaNoEureka}}/swagger-ui/index.html

---