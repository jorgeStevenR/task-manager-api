# 🚀 Task Manager API

API REST desarrollada con **Spring Boot** para la gestión de tareas, subtareas, usuarios y recordatorios, con autenticación JWT y mensajería asíncrona usando RabbitMQ.

---

## 🌐 URL de la API

```
https://tu-api.onrender.com/api](https://task-manager-api-cc7s.onrender.com/
```

---

## 🧠 Características

* ✔ Gestión de usuarios
* ✔ Autenticación con JWT
* ✔ CRUD de tareas
* ✔ Subtareas asociadas
* ✔ Recordatorios programados
* ✔ Envío de mensajes con RabbitMQ
* ✔ Scheduler automático
* ✔ Arquitectura por capas (Controller, Service, Repository, DTO, Mapper)

---

## 🛠️ Tecnologías

* Java 21
* Spring Boot 3
* Spring Security + JWT
* Spring Data JPA
* PostgreSQL (Supabase)
* RabbitMQ (CloudAMQP)
* Docker

---

## ⚙️ Configuración

### Variables de entorno necesarias

```
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

## ▶️ Ejecución local

```
mvn clean package
docker compose up --build
```

---

## 🔐 Autenticación

### Login

**POST** `/api/auth/login`

```
{
  "email": "usuario@email.com",
  "password": "123456"
}
```

### Respuesta

```
{
  "token": "JWT_TOKEN"
}
```

👉 Usa el token en headers:

```
Authorization: Bearer TU_TOKEN
```

---

## 👤 Usuarios

### Crear usuario

**POST** `/api/usuarios`

```
{
  "nombre": "Jorge",
  "email": "jorge@email.com",
  "telefono": "123456789",
  "password": "123456"
}
```

### Listar usuarios

**GET** `/api/usuarios`

---

## 📌 Tareas

### Crear tarea

**POST** `/api/tareas`

```
{
  "titulo": "Mi tarea",
  "descripcion": "Descripción",
  "fechaVencimiento": "2026-03-20T10:00:00",
  "prioridad": "ALTA",
  "usuarioCreadorId": 1,
  "categoriaId": 1,
  "estadoId": 1
}
```

### Obtener tarea

**GET** `/api/tareas/{id}`

### Listar tareas

**GET** `/api/tareas`

### Eliminar tarea

**DELETE** `/api/tareas/{id}`

---

## ✅ Subtareas

### Crear subtarea

**POST** `/api/subtareas`

```
{
  "titulo": "Subtarea",
  "tareaId": 1,
  "responsableId": 1
}
```

### Obtener por tarea

**GET** `/api/subtareas/tarea/{tareaId}`

### Completar subtarea

**PATCH** `/api/subtareas/{id}/completar`

---

## ⏰ Recordatorios

### Crear recordatorio

**POST** `/api/recordatorios`

```
{
  "fechaRecordatorio": "2026-03-20T10:00:00",
  "tipoNotificacion": "EMAIL",
  "tareaId": 1
}
```

### Obtener pendientes

**GET** `/api/recordatorios/pendientes`

---

## 📨 RabbitMQ

La aplicación envía mensajes automáticamente a la cola:

```
recordatorio.queue
```

Cuando:

* Se crea un recordatorio
* El scheduler detecta uno pendiente

---

## ⏱️ Scheduler

Se ejecuta cada:

```
60 segundos
```

Verifica recordatorios pendientes y los envía a RabbitMQ.

---

## 🚀 Deploy

La aplicación está diseñada para desplegarse en:

* Render
* Docker

---

## 📦 Docker

```
docker compose up --build
```

---

## 📌 Estructura del proyecto

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

## 🧑‍💻 Autor

**Jorge Steven Rodríguez Vargas**

* Full Stack Developer
* Java + Spring Boot + Angular
* UNIMINUTO

---

## 📄 Licencia

Uso académico y portafolio
