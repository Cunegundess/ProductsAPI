# Etapa de build com Gradle
FROM gradle:7.6-jdk17 AS build
WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Copia o diretório .gradle do host para o container
COPY ./.gradle ./.gradle

# Torna o wrapper gradle executável
RUN chmod +x gradlew

# Executa o build
RUN ./gradlew clean build -x test --refresh-dependencies

# Etapa final com OpenJDK
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia o arquivo .jar gerado do estágio de build
COPY --from=build /app/build/libs/products-0.0.1-SNAPSHOT.jar ./products.jar

# Expondo a porta para o serviço
EXPOSE 8082

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "products.jar"]
