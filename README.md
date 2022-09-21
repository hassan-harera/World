# World App

Country Info APP based on world postgres database docker image

## Prerequisites

- Docker Version 20.10.18
- World-DB Image Version 2.6
- Git
- Java Version 11
- IntelliJ IDEA 2022.2.2 (Ultimate Edition)

## How to run

- Start Docker
- Run Docker command

```dockerfile
  docker run -d -p 8432:5432 ghusta/postgres-world-db:2.6
```

- Pull repository

```git
  git pull https://github.com/hassan-harera/World.git
```

- Open project on Intellij
- Run project

  **Note** : Project run on port 8080 which may be not idle you can change port
- Enjoy

# Test Examples

### Request

```curl
 curl http://localhost:8080/BHR
```

### Response

```json
 {
  "name": "Bahrain",
  "population": "617000",
  "continent": "Asia",
  "life_expectancy": "73",
  "country_language": "Arabic"
}
```

### Request

```curl
 curl http://localhost:8080/EGY
```

### Response

```json
{
  "name": "Egypt",
  "population": "68470000",
  "continent": "Africa",
  "life_expectancy": "63.3",
  "country_language": "Arabic"
}
```
