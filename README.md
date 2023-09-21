# sprint-boot-servicio-item

# Prod: http://localhost:8007/obtener-config
# DEV: http://localhost:8005/obtener-config

   # DOCKER
## generar .jar: .\mvnw clean package -DskipTests
## generar imagen: docker build -t servicio-items:v1 .
## creando red: docker network create sprintcloud
## levantando servicio: docker run -d -p 8002:8002 -p 8005:8005 -p 8007:8007 --name servicio-items --network sprintcloud servicio-items:v1
   