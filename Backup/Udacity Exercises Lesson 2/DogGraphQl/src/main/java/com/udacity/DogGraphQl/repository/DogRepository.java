package com.udacity.DogGraphQl.repository;

import com.udacity.DogGraphQl.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
