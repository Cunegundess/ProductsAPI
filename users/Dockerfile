# # Etapa de build com Gradle
# FROM gradle:7.6-jdk17 AS build
# WORKDIR /app
#
# # Copia os arquivos do projeto
# COPY . .
#
# # Copia o diretório .gradle do host para o container
# COPY ./.gradle ./.gradle
#
# # Torna o wrapper gradle executável
# RUN chmod +x gradlew
#
# # Executa o build
# RUN ./gradlew clean build -x test --refresh-dependencies
#
# # Etapa final com OpenJDK
# FROM openjdk:17-jdk-slim
# WORKDIR /app
#
# # Copia o arquivo .jar gerado do estágio de build
# COPY --from=build /app/build/libs/users-0.0.1-SNAPSHOT.jar ./users.jar
#
# # Expondo a porta para o serviço
# EXPOSE 8081
#
# # Comando para iniciar a aplicação
# ENTRYPOINT ["java", "-jar", "users.jar"]

FROM gradle:8.2.1-jdk17
WORKDIR /app

# Copiar todos os arquivos do projeto para o contêiner
COPY . .

# Torna o Gradle Wrapper executável
RUN chmod +x gradlew

# Expor a porta usada pelo Spring Boot
EXPOSE 8081

# Comando para rodar a aplicação no modo de desenvolvimento com hot-reloading
CMD ["./gradlew", "bootRun", "--no-daemon"]
