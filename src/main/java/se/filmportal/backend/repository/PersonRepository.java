package se.filmportal.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se.filmportal.backend.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}