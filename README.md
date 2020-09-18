# Reto Mutante
Reto mutante proceso de seleccion

# Descripción
En este repositorio se tienen 2 proyectos en java construidos con maven.

El primer proyecto ubicado en la carpeta RetoMutante contiene la lógica para los niveles 1 y 2
El segundo proyecto en la carpeta StatsMutante contiene un aplicativo muy sencillo que cumple con la funcionalidad solicitada en el nivel 3 del reto.

# Despliegue Cloud
Para completar el rto nivel 2 y 3 se selecciono realizar el despliegue en AWS utilizando los siguientes servicios:

* AWS LAmbda(2 funciones)
* AWS API gateway (2 servicios)
* DynamoDB

La principal ventaja de elegir el modelo de AWS lambda es el consumo por demanda de las cargas de trabajo del servicio, con ello se reducen costos de implementacion y por otra parte se garantiza niveles de disponibilidad y escalabilidad del sistema de acuerdo con los SLA de AWS Lambda. Con esto se pueden garantizar servicio para 20 o un millon de usuarios y el pago del cloud sera directamente proporcional a la demanda de recursos.

Se Seleccionó utilizar DynamoDB al ser una Base de datos No relacional la cual tiene alta flexibilidad y performance para escalamiento en tiempo cercano al real. Adicionl para efectos del reto se aprovecha la capa free de dynamoDB

Se utiliza el API gateway ya que cuenta con niveles de Alta disponibilidad y seguridad para integraciones HTTP las cuales pasan a ser segurasautomaticamente a traves de HTTPS.

Diagrama de referencia:
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
