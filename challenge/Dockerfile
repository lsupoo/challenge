FROM java:8

WORKDIR /app

# Copiamos el JAR de nuestra aplicación a la imagen Docker
COPY target/challenge-0.0.1-SNAPSHOT.jar /app

#Exponemos el puerto 8080
EXPOSE 8080

# Corremos el archivo JAR
CMD ["java","-jar","challenge-0.0.1-SNAPSHOT.jar"]