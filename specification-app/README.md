# 🔎 Specification
By Anthony Vilarim Caliani

[![#](https://img.shields.io/badge/licence-MIT-blue.svg)](#)

Learning about JPA + Specification.

## 🔌 API Usage
```bash
# List users
curl http://localhost:8080/student

# Return specific user
curl http://localhost:8080/student/1

# Return user by e-mail or passport
curl "http://localhost:8080/student/search?email=anthony@github.com&passport=A1234567"
```
