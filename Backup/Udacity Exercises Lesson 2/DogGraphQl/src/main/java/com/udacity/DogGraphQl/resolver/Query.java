package com.udacity.DogGraphQl.resolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.DogGraphQl.entity.Dog;
import com.udacity.DogGraphQl.exception.DogNotFoundException;
import com.udacity.DogGraphQl.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver{
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository){this.dogRepository=dogRepository;}

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }
    public Dog findDogById(Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent()){
            return optionalDog.get();
        }
        else{
            throw new DogNotFoundException("Dog not found", id);
        }
    }
}
