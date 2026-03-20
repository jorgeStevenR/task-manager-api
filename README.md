# Task Manager API

API REST desarrollada con **Spring Boot 3 + Java 21** para la gestión de tareas, subtareas, usuarios y recordatorios, con autenticación JWT y mensajería asíncrona usando RabbitMQ.

---

## URL Base

```
https://task-manager-api-cc7s.onrender.com/api
```

---

## Características

* 🔐 Autenticación con JWT
* 👤 Gestión de usuarios
* 📌 CRUD de tareas
* ✅ Subtareas asociadas
* ⏰ Recordatorios programados
* 📨 Integración con RabbitMQ
* ⏱️ Scheduler automático
* 🧱 Arquitectura en capas (Controller, Service, Repository, DTO, Mapper)

---

## Tecnologías

* Java 21
* Spring Boot 3
* Spring Security + JWT
* Spring Data JPA
* PostgreSQL (Supabase)
* RabbitMQ (CloudAMQP)
* Docker

---

# Autenticación

## Login

**POST** `/auth/login`

### Request

```json
{
  "email": "usuario@email.com",
  "password": "123456"
}
```

### Response

```json
{
  "token": "JWT_TOKEN"
}
```

---

## Registro

**POST** `/auth/register`

### Request

```json
{
  "nombre": "Jorge",
  "email": "jorge@email.com",
  "password": "123456"
}
```

### Response

```json
{
  "token": "JWT_TOKEN"
}
```

---

## Uso del token

```
Authorization: Bearer TU_TOKEN
```

---

# Usuarios

## Crear usuario

**POST** `/usuarios`

```json
{
  "nombre": "Jorge",
  "email": "jorge@email.com",
  "telefono": "123456789",
  "password": "123456"
}
```

---

## Obtener usuario

**GET** `/usuarios/{id}`

---

## Listar usuarios

**GET** `/usuarios`

---

## Eliminar usuario

**DELETE** `/usuarios/{id}`

---

# Tareas

## Crear tarea

**POST** `/tareas`

```json
{
  "titulo": "Mi tarea",
  "descripcion": "Descripción de la tarea",
  "fechaVencimiento": "2026-03-20T10:00:00",
  "prioridad": "ALTA",
  "usuarioCreadorId": 1,
  "categoriaId": 1,
  "estadoId": 1
}
```

---

## Obtener tarea

**GET** `/tareas/{id}`

---

## Listar tareas

**GET** `/tareas`

---

## Eliminar tarea

**DELETE** `/tareas/{id}`

---

# Subtareas

## Crear subtarea

**POST** `/subtareas`

```json
{
  "titulo": "Subtarea importante",
  "tareaId": 1,
  "responsableId": 1
}
```

---

## Obtener subtareas por tarea

**GET** `/subtareas/tarea/{tareaId}`

---

## Completar subtarea

**PATCH** `/subtareas/{id}/completar`

---

# Recordatorios

## Crear recordatorio

**POST** `/recordatorios`

```json
{
  "fechaRecordatorio": "2026-03-20T10:00:00",
  "tipoNotificacion": "EMAIL",
  "tareaId": 1
}
```

---

## Obtener recordatorios pendientes

**GET** `/recordatorios/pendientes`

---

# RabbitMQ

La aplicación envía mensajes automáticamente a la cola:

```
recordatorio.queue
```

### Se ejecuta cuando:

* Se crea un recordatorio
* El scheduler detecta recordatorios pendientes

---

# Scheduler

* Se ejecuta cada **60 segundos**
* Busca recordatorios no enviados
* Los envía a RabbitMQ

---

# Variables de entorno

```env
SPRING_DATASOURCE_URL=jdbc:postgresql://...
SPRING_DATASOURCE_USERNAME=...
SPRING_DATASOURCE_PASSWORD=...

SPRING_RABBITMQ_HOST=...
SPRING_RABBITMQ_PORT=5671
SPRING_RABBITMQ_USERNAME=...
SPRING_RABBITMQ_PASSWORD=...
SPRING_RABBITMQ_VIRTUAL_HOST=...
```

---

# Ejecución local

```bash
mvn clean package
docker compose up --build
```

---

# Estructura del proyecto

```
controller/
service/
repository/
mapper/
dto/
entity/
config/
security/
messaging/
scheduler/
```

---

# Mejoras futuras

* ✅ Paginación (`Pageable`)
* ✅ Filtros por prioridad, estado y usuario
* ✅ Manejo global de errores (`@ControllerAdvice`)
* ✅ Documentación Swagger/OpenAPI
* ✅ Refresh Token
* ✅ Soft delete
* ✅ Tests unitarios (JUnit + Mockito)

---

# Autor

**Jorge Steven Rodríguez Vargas**
Full Stack Developer
Java + Spring Boot + Angular
UNIMINUTO

---

# Licencia

Uso académico y portafolio
