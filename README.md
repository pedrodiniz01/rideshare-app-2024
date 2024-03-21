# RideShare System

The rideshare project is a backend application developed in Spring Boot integrated with Apache Kafka for a rideshare platform.

# 1. Application setup
There's a docker compose file that quickly instantiates a kafka, zookeeper and rideshare container. These 3 containers are ready communicate with eachother. 
Deployment is very simple, just run:
```bash
docker-compose up
```

#### Postman Collection:
You can find a Postman collection containing interactions with all API endpoints at ./rideshare/postman folder.

#### Spring Boot Application URL:
The Spring Boot application runs at port :8080.

#### Database Storage:
To check the database storage, a H2 memory database is utilized. Access the database console at: http://localhost:8080/h2-console

You are ready to start simulating with requests and access database =)


