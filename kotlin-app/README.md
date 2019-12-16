# 🃏 Kotlin App
By Anthony Vilarim Caliani

[![#](https://img.shields.io/badge/licence-MIT-blue.svg)](#) [![#](https://img.shields.io/badge/kotlin-1.3.x-blue.svg)](#) [![#](https://img.shields.io/badge/spring--boot-2.2.x-brightgreen.svg)](#)

## Description
Very simple RESTful API using Kotlin and Spring Boot.

## API Usage
```sh
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

---

_You can find [@avcaliani](#) at [GitHub](https://github.com/avcaliani) or [GitLab](https://gitlab.com/avcaliani)._