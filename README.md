# UD.BaseDeDatoAvanzada.ProyectoFinal

# Propiedades de la aplicacion en el archivo application.properties

Usar el archivo application.properties para configurar la aplicacion
en docker-compose.yml se usa el archivo application.properties para configurar la aplicacion, por ende se debe configurar el archivo application.properties para que funcione en docker-compose.yml

## Docker

```properties
server.port= ${PORT}
spring.web.resources.static-locations=classpath:/static/
spring.datasource.url = ${DATABASE_URL}
spring.datasource.username = ${DATABASE_USERNAME}
spring.datasource.password = ${DATABASE_PASSWORD}
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto = update
spring.security.user.name = ${SECURITY_USERNAME}
spring.security.user.password = ${SECURITY_PASSWORD}
```

## Local

```properties
server.port= 8080
spring.web.resources.static-locations=classpath:/static/
spring.datasource.url = jdbc:postgresql://localhost:5400//tranqui_descanso
spring.datasource.username = postgres
spring.datasource.password = root
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto = update
spring.security.user.name = admin
spring.security.user.password = admin
```

# Docker-Compose

- Crear el packete es con `./mvnw clean package -DskipTests`
- para ejecuita un actualizacion `docker-compose up --build`
- Para ejecutar services `docker-compose up`
- para ejecutar un solo servicio `docker-compose up <service_name>`
- para errores de network `docker-compose up --force-recreate --build`
# Orden de subir datos a la base de datos
1. usuario
2. telefono_usuario
3. responsable
4. municipio
5. agencia
6. hotel
8. hotel_telefono
9. servicio
10. habitacion
11. reserva
12. pago
14. usar
15. registro
# Arquitetura
Se esta usando MVC para la arquitectura de la aplicacion
## Modelo
```
└── 📁Model
    └── 📁BD
        └── 📁DTO
    └── 📁DAO
    └── 📁Interfaces
        └── 📁DTO
        └── 📁Services
```
## Vista
```
└── 📁resources
    └── application.properties
    └── 📁static
        └── 📁bootstrap-icons-1.10.5
            └── 📁font
                └── 📁fonts
    └── 📁templates
        └── 📁agencia
        └── caratula.html
        └── 📁cliente
        └── 📁empleado
        └── index.html
        └── login.html
```
## Controladores
```
└── 📁Controllers
    └── 📁ServicesCTO
        └── HotelCTO.java
        └── MunicipioCTO.java
        └── RegistroCTO.java
        └── ReservaCTO.java
        └── Telefono_UsuarioCTO.java
        └── UsuarioCTO.java
        └── 📁Util
            └── TelefonoRequestUser.java
    └── 📁TemplatesCTO
        └── IndexCTO.java
        └── LoginCTO.java
```