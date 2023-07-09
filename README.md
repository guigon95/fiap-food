
# Fiap-food


Fast food self-service

## Prerequisites:
- Apache Maven 3.+
- JDK 20
- Docker 20+
- Docker Compose 1.22.+

## Start application in Docker container with Mysql DB in Docker:
```
    docker-compose up -d
```

## Start application in Docker container with Mysql DB in Docker and rebuild service image:
```
    docker-compose up --build --force-recreate --no-deps -d 
```

## Swagger documentation:
```
    http://localhost:8080/swagger-ui.html
```

## Database access via Adminer:
```
    http://localhost:8282/
```

![img.png](docs/adminer_login.png)

* **Infos**:
  * User = **root** 
  * password = **password**
  * Database = **fiapfoodt**

![img.png](docs/adminer_home.png)

**OBS: If you want to prepopulate the database, we have a script with some essential random inserts and it can be performed on the import screen**

SQL file `src/main/resources/scripts/population-db.sql`

![img.png](docs/adminer-import.png)