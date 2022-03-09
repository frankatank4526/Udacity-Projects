package com.udacity.DogGraphQl.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.DogGraphQl.entity.Dog;
import com.udacity.DogGraphQl.exception.BreedNotFoundException;
import com.udacity.DogGraphQl.exception.DogNotFoundException;
import com.udacity.DogGraphQl.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository){this.dogRepository=dogRepository;}

    public boolean deleteDogBreed(String breed){
        boolean deleted = false;
        Iterable<Dog> dogList = dogRepository.findAll();

        for(Dog d : dogList){
            if(d.getBreed().equals(breed)){
                dogRepository.delete(d);
                deleted = true;
            }
        }
        if(!deleted){
            throw new BreedNotFoundException("Breed not found", breed);
        }
        return deleted;
    }
    public Dog updateDogName(String newName, Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent()){
            Dog dogToSave = optionalDog.get();
            dogToSave.setName(newName);
            dogRepository.save(dogToSave);
            return dogToSave;
        }
        else{
            throw new DogNotFoundException("Dog not found", id);
        }
    }
}
