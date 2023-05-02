# A partir da imagem abaixo, construiremos nossa imagem. Quando nosso container for criado, já estará com a JDK abaixo instalada:
FROM openjdk:17-alpine
# Cria o usuário Spring para realizarmos nossas operações. Inserido pra evitarmos problemas de segurança com o root:
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
# Linha de argumento, no caso abaixo, faz referência ao que estiver na pasta target e finalizar com *.jar (pq não sabe o nome do nosso arquivo):
# Maven:
# ARG JAR_FILE=target/*.jar
# Gradle:
# Quando tem mais de um arquivo jar, precisamos retirar o *.jar
# ARG JAR_FILE=build/libs/*.jar
ARG JAR_FILE=build/libs/formacao-java-microsservicos-ms-pedidos-0.0.1-SNAPSHOT.jar
# Copia esse arquivo para dentro do nosso container com o nome "app.jar":
COPY ${JAR_FILE} /app.jar
# Comando para rodarmos a aplicação copiada acima:
ENTRYPOINT ["java", "-jar", "/app.jar"]
# Pra gerar o jar e conseguirmos fazer o build da imagem, rodar:
    # Maven: mvn clean package
    # Gradle: ./gradlew build

