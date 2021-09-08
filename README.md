# Students API (Java)

### Development

```properties
server.servlet.context-path=/api

spring.datasource.url=jdbc:postgresql://localhost:6652/students
spring.datasource.username=student_user
spring.datasource.password=student_password

server.port=8963
```

### Docker build and run

```properties
server.port=8930
```

```shell
./docker-run up

./docker-run down
```

### API

```
POST /api/branch
PUT  /api/branch/{id}
GET  /api/branch/{id}
GET  /api/branch/all?page=[page]&size=[size]

POST /api/student
PUT  /api/student/{id}
GET  /api/student/{id}
GET  /api/student/all?page=[page]&size=[size]&branch=[branch-id]&year=[year]
```