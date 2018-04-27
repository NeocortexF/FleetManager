package com.example.demo.beer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//class that leverages Spring Data to do CRUD on this entity.
//Add a @RepositoryRestResource annotation to BeerRepository
//to expose all its CRUD operations as REST endpoints.
@RepositoryRestResource
interface BeerRepository extends JpaRepository<Beer, Long> {
}