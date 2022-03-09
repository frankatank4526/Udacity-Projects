package com.udacity.dogProject.service;

import com.udacity.dogProject.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> retrieveDogs();

    List<String> retrieveDogBreed();

    String retrieveDogBreedById(Long id);

    List<String> retrieveDogNames();

}
