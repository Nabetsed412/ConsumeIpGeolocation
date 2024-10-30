
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

## Base de Datos H2

Puedes acceder a la consola de la base de datos H2 para ver los datos almacenados y realizar consultas:

- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:geolocationdb`
- **Usuario**: `sa`
- **Contraseña**: *(dejar en blanco)*

## Ejemplo de Uso

1. Ejecuta la aplicación con `mvn spring-boot:run`.
2. Accede a la consola de la base de datos H2 para verificar los datos.
3. Al subir el Api, se puede realizar mendiante postman el consumo del servicio:

```
curl --location 'http://localhost:8080/api/geolocation/stats'
```

Obteniendo como resultado  las estadisticas de acuerdo a los registros almacenados en la base de datos H2, la estructura de respuesta es (ejemplo):

```
{
    "minDistance": 2996.0,
    "maxDistance": 9994.0,
    "averageDistance": 9498.0,
    "minDistanceCountry": "Brazil",
    "maxDistanceCountry": "Spain"
}
```

## Adicionales

Se creo un archivo *scriptTest.js* que contiene un script para realizar test de fluctuacion de trafico, este fue implementado en el docker y se podra visualizar y/o modificar para sus respectivas pruebas. 


## Durante el Desarrollo

1. inicialmente la base de datos H2 se utilizo como tipo server para consultar los datos que fueron insertados desde la api Java.
2. En la consulta que de promedio se tenia la siguiente consulta:
   /*@Query("SELECT AVG(tmp2.a) FROM (SELECT tmp.ic * tmp.distance AS a FROM (SELECT SUM(g.iterationCount) AS ic, g.distance, g.countryName FROM Geolocation as g GROUP BY g.distance, g.countryName) AS tmp) AS tmp2")
    Double findAverageDistance();*/ 
3. Se implemento una especie de Rate-Limiting para controlar la cantidad de solicitudes que un usuario.
4. Se realizaron pruebas automaticas de consumo para validar el rendimiento del aplicativo.
5. Se creo un docker para ambas aplicaciones y la configuracion de red quedo la misma para ambas, adicionalmente se creo un docker para las pruebas de rendimiento.


## Licencia

Uso personal

## Desarrollado por

Este proyecto fue desarrollado por [Nabetsed412](https://github.com/Nabetsed412).
