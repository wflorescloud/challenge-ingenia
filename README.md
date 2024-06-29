# para construir imagen de docker manual si se quiere
docker build -t challange-ingenia:0.0.1 .

# correr contenedor a través de docker-compose- up
 docker-compose up

# correr contenedor a través de docker-compose- up en segundo plano
 docker-compose up -d

# cuando la aplicación esta levantada se puede acceder al swagger en la siguiente url
http://localhost:8080/challenge/api/swagger-ui/index.html


# la url para acceder a la consola de h2
http://localhost:8080/challenge/api/h2-console


 
 


