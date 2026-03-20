# 🚀 Task Manager API

API REST desarrollada con **Spring Boot 3 + Java 21** para la gestión de tareas, subtareas, usuarios y recordatorios, con autenticación JWT y mensajería asíncrona usando RabbitMQ.

---

## 🌐 URL Base https://task-manager-api-cc7s.onrender.com/api



---

## 🧠 Características

- 🔐 Autenticación con JWT
- 👤 Gestión de usuarios
- 📌 CRUD de tareas
- ✅ Subtareas asociadas
- ⏰ Recordatorios programados
- 📨 Integración con RabbitMQ
- ⏱️ Scheduler automático
- 🧱 Arquitectura en capas (Controller, Service, Repository, DTO, Mapper)

---

## 🛠️ Tecnologías

- Java 21
- Spring Boot 3
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL (Supabase)
- RabbitMQ (CloudAMQP)
- Docker

---

# 🔐 Autenticación

## Login

**POST** `/auth/login`

### Request
```json
{
  "email": "usuario@email.com",
  "password": "123456"
}

### Response
{
  "token": "JWT_TOKEN"
}
