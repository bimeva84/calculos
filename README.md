# calculos
La aplicación es hecha para servicios back tipo REST:
•	Java 8 (Para revisar dependencias remitirse al pom.xml)
•	Spring Boot 2.4.2 
Front con Angular 10 (para revisar dependencias remitirse al archiva packege.json contenido en el proyecto)

DOCKER:
•	Servicio Back
o	Ubicación de Dockerfile y War:
	..\calculos\src\main\resources
	En consola se debe ejecutar el comando: 
•	docker build --tag calculos:1.0 .
	Después para ejecutar la imagen en la consola:
•	docker run --restart=unless-stopped -p 8037:8037 -e "TZ=America/Bogota" --name calculos calculos:1.0
	En el misma raíz se encuentra un archivo JSON (PostMan) para consumir los servicios con el nombre Calculos.postman_collection.json
•	Front
o	Ubicación Dockerfile y .dockerignore:
	..\calculos\calculosFront
	En consola se debe ejecutar el comando: 
•	docker build -t calculosfront .
	Después para ejecutar la imagen en la consola:
•	docker run -p 4200:80 --name calculos-app calculosfront
	Se puede acceder a la UI por medio de la URL http://localhost:4200/calcular

