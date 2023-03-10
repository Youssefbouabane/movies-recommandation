# movies-recommandation

## Overview

An application that allows to recommend a list of movies to watch

## Getting Started

How to install and run the application

### Prerequis

- JDK 17
- Maven 3.6.3

### Installation

```bash
$ git clone https://github.com/Youssefbouabane/movies-recommandation.git
$ cd movies-recommandation
$ mvn package spring-boot:run
```

## Documentation

Documentation URL : http://localhost:8085/swagger-ui/index.html

### Services

The /recommendations endpoint accept a query parameter genre that contains the user's preferred movie genre. The endpoint return a list of movies that belong to the specified genre, sorted by release year in descending order.

### Genres : Action, Drama, Comedy, Adventure, Crime

#### Exemple : 

Request : GET http://localhost:8085/recommendations?genre=drama
<br>
Response :
<b>
```bash
[
  {
    "id": 11,
    "title": "Slumdog Millionaire",
    "genre": "Drama",
    "releaseYear": 2008,
    "director": "Danny Boyle"
  },
  {
    "id": 1,
    "title": "The Shawshank Redemption",
    "genre": "Drama",
    "releaseYear": 1994,
    "director": "Frank Darabont"
  },
  {
    "id": 2,
    "title": "The Godfather",
    "genre": "Drama",
    "releaseYear": 1972,
    "director": "Francis Ford Coppola"
  }
]
```
### Movie repository

You can find the movie repository ( list of movies ) in file static/movies.json.
