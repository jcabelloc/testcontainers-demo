# Apuntes

### Para correr testcontainers, agregar la variable de entorno al ide
```
PATH = $PATH:/usr/local/bin
```

### Nota
```
Adding this Testcontainers library JAR will not automatically add a database driver JAR to your project. 
You should ensure that your project also has a suitable database driver as a dependency.
```

### Example of creating an image with pre-built DB

* https://github.com/oracle/docker-images/blob/master/OracleDatabase/SingleInstance/samples/prebuiltdb/README.md
```

docker run --name oracledb -p 1521:1521 -p 5500:5500 oracle/database:18.4.0-xe

docker exec oracledb ./setPassword.sh secreto

docker stop -t 120 oracledb

docker commit -m "Image with prebuilt database" oracledb oracle/db-prebuilt:18.4.0-xe

docker rm oracledb



```

* Probar la imagen creada (opcional)
```
docker run --name oracledb -p 1521:1521 -p 5500:5500  -e ORACLE_PWD=secreto oracle/db-prebuilt:18.4.0-xe

```