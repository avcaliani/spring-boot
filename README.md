# Spring Boot Repository
By Anthony Vilarim Caliani

[![#](https://img.shields.io/badge/Java_JDK-10-red.svg)](#)
[![#](https://img.shields.io/badge/Maven-yes-3498db.svg)](#)
[![#](https://img.shields.io/badge/Apache_Tomcat-embed-yellow.svg)](#)

[![#](https://img.shields.io/badge/Spring-2.0.4.RELEASE-green.svg)](#)
[![#](https://img.shields.io/badge/WEB-yes-brightgreen.svg)](#)
[![#](https://img.shields.io/badge/JPA-yes-orange.svg)](#)
[![#](https://img.shields.io/badge/Lombok-yes-ff69b4.svg)](#)
[![#](https://img.shields.io/badge/MySQL-yes-blue.svg)](#)
[![#](https://img.shields.io/badge/H2-yes-lightgray.svg)](#)


# Projects Description
These are small Spring API projects. Here I've learned how to do the basic stuffs like:
- Controllers
    - Generic Response
    - Exception Handler
- Services
- Model
    - Entities
    - DTOs
- Repositories
- Named Queries
- Specifications
- Use and Configure JPA

I've created Spring Application with their dependencies [Here \o/](https://start.spring.io/) and after that I've imported Spring Application into [IntelliJ](https://www.jetbrains.com/idea/download/) idea. That's all.

I hope It helps! Thanks

# Projects Map

## Skeleton Project Map
```
skeleton/
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── br
    │   │       └── avcaliani
    │   │           └── skeleton
    │   │               ├── SkeletonApplication.java
    │   │               ├── controllers
    │   │               │   ├── TaskController.java
    │   │               │   └── utils
    │   │               │       ├── HandlerController.java
    │   │               │       └── Response.java
    │   │               ├── exceptions
    │   │               │   └── TaskException.java
    │   │               ├── model
    │   │               │   ├── dtos
    │   │               │   │   ├── SubTaskDTO.java
    │   │               │   │   └── TaskDTO.java
    │   │               │   └── entitites
    │   │               │       ├── SubTask.java
    │   │               │       └── Task.java
    │   │               ├── repositories
    │   │               │   └── TaskRepository.java
    │   │               ├── services
    │   │               │   ├── TaskService.java
    │   │               │   └── impl
    │   │               │       └── TaskServiceImpl.java
    │   │               └── utils
    │   │                   └── Messages.java
    │   └── resources
    │       ├── application-dev.properties
    │       ├── application-prod.properties
    │       ├── application.properties
    │       └── data.sql
    └── test
        └── java
            └── br
                └── avcaliani
                    └── skeleton
                        ├── SkeletonApplicationTests.java
                        └── services
                            └── TaskServiceTest.java
```

## Specification Project Map
```
skeleton/
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── br
    │   │       └── avcaliani
    │   │           └── skeleton
    │   │               ├── SkeletonApplication.java
    │   │               ├── controllers
    │   │               │   ├── TaskController.java
    │   │               │   └── utils
    │   │               │       ├── HandlerController.java
    │   │               │       └── Response.java
    │   │               ├── exceptions
    │   │               │   └── TaskException.java
    │   │               ├── model
    │   │               │   ├── dtos
    │   │               │   │   ├── SubTaskDTO.java
    │   │               │   │   └── TaskDTO.java
    │   │               │   └── entitites
    │   │               │       ├── SubTask.java
    │   │               │       └── Task.java
    │   │               ├── repositories
    │   │               │   └── TaskRepository.java
    │   │               ├── services
    │   │               │   ├── TaskService.java
    │   │               │   └── impl
    │   │               │       └── TaskServiceImpl.java
    │   │               └── utils
    │   │                   └── Messages.java
    │   └── resources
    │       ├── application-dev.properties
    │       ├── application-prod.properties
    │       ├── application.properties
    │       └── data.sql
    └── test
        └── java
            └── br
                └── avcaliani
                    └── skeleton
                        ├── SkeletonApplicationTests.java
                        └── services
                            └── TaskServiceTest.java
```

## Thanks
Thank You Guilherme Chiavegatto for teach me how to make a Spring Boot Application from scratch.

---

_You can find [@avcaliani](#) at [GitHub](https://github.com/avcaliani) or [GitLab](https://gitlab.com/avcaliani)._
