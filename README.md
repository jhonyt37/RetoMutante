# Reto Mutante
Reto mutante proceso de seleccion

# Descripción
En este repositorio se tienen 2 proyectos en java 8 construidos con maven.

El primer proyecto se encuentra ubicado en la carpeta RetoMutante, contiene la lógica para los niveles 1 y 2
El segundo proyecto esta en la carpeta StatsMutante y contiene un aplicativo sencillo que cumple con la funcionalidad solicitada en el nivel 3 del reto.

# Despliegue Cloud
Para completar el reto nivel 2 y 3 se seleccionó realizar el despliegue en el cloud de AWS utilizando los siguientes servicios:

* AWS LAmbda(2 funciones)
* AWS API gateway (2 servicios)
* DynamoDB

Esta arquitectura simple y eficiente es potente y satisface las necesidades del reto con fluctuaciones de carga agresivas sin degradacion de servicio.

La principal ventaja de elegir el modelo de AWS lambda es el consumo por demanda de las cargas de trabajo del servicio, con ello se reducen costos de implementación y por otra parte se garantiza niveles de disponibilidad y escalabilidad del sistema de acuerdo con los SLA de AWS Lambda. 

Se Seleccionó utilizar DynamoDB al ser una Base de datos No relacional la cual tiene alta flexibilidad y performance para escalamiento en tiempo cercano al real. Adicional, para efectos del reto se aprovecha la capa free de dynamoDB en AWS.

Se utiliza el servicio administrado de AWS API gateway ya que facilita la implementacon de APIS y cuenta con niveles de Alta disponibilidad y seguridad para integraciones HTTPS.

# Diagrama de referencia:
<img src="https://i.ibb.co/ZW0rDjx/diagrama.png">

# Modo de uso del servicio
En un cliente HTTP como Postman o jmeter consumir los siguientes servicios:

1. Verificar mutante: https://mw8c3vnril.execute-api.us-east-1.amazonaws.com/test/mutant/

Metodo POST
Body ejemplo:
{ "dna":["ATCTTT","TTAATC","TTATGT","ATAAGG","ACCCTA","TCACTG"]  }


Este metodo cumple con los requisitos funcionales solicitados para el nivel 1 del reto.

2. Consultar estadisticas https://mw8c3vnril.execute-api.us-east-1.amazonaws.com/test/mutant/stats

Metodo GET

No hay restriccion de horarios o indisponibilidad de ambientes para ejecutar pruebas del servicio.
