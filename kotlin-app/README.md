# 😎 Kotlin App
By Anthony Vilarim Caliani

[![#](https://img.shields.io/badge/licence-MIT-blue.svg)](#) [![#](https://img.shields.io/badge/kotlin-1.3.x-deeppink.svg)](#) [![#](https://img.shields.io/badge/spring--boot-2.2.x-brightgreen.svg)](#)

Very simple RESTful API using Kotlin and Spring Boot.

## 🔌 API Usage
```bash
# List users
curl http://localhost:8080/user

# Return specific user
curl http://localhost:8080/user/0

# Create new user
curl -d '{ "name": "Anthony", "email": "avcaliani@github.com" }' \
     -H 'Content-Type: application/json' \
     -X POST http://localhost:8080/user

# Remove user
curl -X DELETE http://localhost:8080/user/0
```

## 🐳 Docker
```bash
# Building docker image...
docker build -t kotlin-app .

# Running docker image...
docker run -d -p 8080:8080 --name kotlin-app kotlin-app
```
