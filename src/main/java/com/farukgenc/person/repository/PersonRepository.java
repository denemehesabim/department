package com.farukgenc.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farukgenc.person.domain.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
