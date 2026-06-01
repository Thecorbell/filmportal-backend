# FilmPortal Backend

Backend API for a film festival and film submission platform.

## Tech Stack

* Java 21
* Spring Boot
* PostgreSQL
* Spring Data JPA
* Maven

## Features

### Films

* Create film
* Update film
* Delete film
* Get film by id
* List all films

### Persons

* Create person
* Update person
* Delete person
* Get person by id
* List all persons

### Film-Person Relations

* Link people to films
* Store role (Director, Producer, Writer, etc.)
* Get all persons for a film
* Get all films for a person

### DTO Responses

* FilmPersonResponse
* PersonFilmResponse

## API Examples

GET /api/films

GET /api/persons

GET /api/films/{id}/persons

GET /api/persons/{id}/films
