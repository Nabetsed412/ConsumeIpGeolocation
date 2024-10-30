
# ConsumeIpGeolocation

## Descripción General

El proyecto `ConsumeIpGeolocation` es una aplicación desarrollada en **Spring Boot** que permite consumir información de geolocalización basada en direcciones IP. La aplicación hace consultas a una base de datos y calcula estadísticas como la distancia mínima, máxima y promedio entre diferentes ubicaciones.

## Características

- **Consumo de API de geolocalización**: La aplicación consulta servicios de geolocalización externos utilizando direcciones IP y almacena los resultados en una base de datos H2.
- **Cálculo de estadísticas**: Proporciona la distancia mínima, máxima y promedio entre las ubicaciones geográficas almacenadas.
- **Base de datos H2**: Se utiliza una base de datos H2 embebida para almacenar y consultar los datos geográficos.
  
## Tecnologías Utilizadas

- **Java**: Lenguaje principal del proyecto.
- **Spring Boot**: Framework para simplificar la creación de aplicaciones Java.
- **H2 Database**: Base de datos en memoria para almacenar los datos geográficos.
- **Maven**: Herramienta de gestión de dependencias y construcción de proyectos.

## Requisitos

- **Java 11** o superior.
- **Maven 3.6+** para gestionar las dependencias del proyecto.

## Instalación y Configuración

1. Clona el repositorio:

   ```bash
   git clone https://github.com/Nabetsed412/ConsumeIpGeolocation.git
   cd ConsumeIpGeolocation
   ```

2. Construye el proyecto con Maven:

   ```bash
   mvn clean install
   ```

3. Ejecuta la aplicación:

   ```bash
   mvn spring-boot:run
   ```

## Endpoints Disponibles

A continuación se presentan los endpoints principales de la API:

1. **Obtener estadísticas de distancias**:

   ```http
   GET /api/v1/distances/stats
   ```

   Este endpoint devuelve la distancia mínima, máxima y promedio calculadas a partir de los registros almacenados en la base de datos.

2. **Consultar geolocalización por IP**:

   ```http
   GET /api/v1/geolocation/{ip}
   ```

   Este endpoint recibe una dirección IP como parámetro y devuelve la información de geolocalización asociada a esa IP.

## Base de Datos H2

Puedes acceder a la consola de la base de datos H2 para ver los datos almacenados y realizar consultas:

- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:geolocationdb`
- **Usuario**: `sa`
- **Contraseña**: *(dejar en blanco)*

## Ejemplo de Uso

1. Ejecuta la aplicación con `mvn spring-boot:run`.
2. Accede a la consola de la base de datos H2 para verificar los datos.
3. Obtén las estadísticas de distancias almacenadas:

   ```bash
   curl http://localhost:8080/api/v1/distances/stats
   ```

## Licencia

Uso personal

## Desarrollado por

Este proyecto fue desarrollado por [Nabetsed412](https://github.com/Nabetsed412).
