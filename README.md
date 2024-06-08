
# This is a simple API for ToDoList project

## Requirements 
- JDK 22 (https://www.oracle.com/fr/java/technologies/downloads/#jdk22-windows)
- Maven 3.9.0 (https://maven.apache.org/download.cgi)
> You have to setup environment variables to these folders jdk22 and maven

## Run the API
- Run this command in the root folder of the project `mvn spring-boot:run`

## Swagger UI
- Open this url to see all endpoints and their configurations http://localhost:8080/swagger-ui/index.html

## Data base
> The application uses an H2 database, to connect to the db you can access to this endpint (http://localhost:8080/h2-console)
- **JDBC URL** : `jdbc:h2:mem:todolist`
- **name** : h2


![image](https://github.com/Hourani963/todolist/assets/81326209/95ffaf73-303f-4f84-a068-9eb8c9f70e9a)
