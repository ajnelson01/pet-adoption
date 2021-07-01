package com.vmware.dogapi.dog;

import com.vmware.dogapi.dog.internal.DogEntity;
import com.vmware.dogapi.dog.internal.DogRepository;
import com.vmware.dogapi.dog.internal.NoSuchDogException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DogService {
    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<DogDto> getDogs() {
        List<DogEntity> dogs = dogRepository.findAll();
        return dogs.stream().map(dogEntity -> DogDto.builder()
                .id(dogEntity.getId())
                .name(dogEntity.getName())
                .age(dogEntity.getAge())
                .type(dogEntity.getType())
                .imageUrl(dogEntity.getImageUrl())
                .gender(dogEntity.getGender().name())
                .build()).collect(Collectors.toList());
    }

    public DogDto getById(Long dogId) {
        Optional<DogEntity> dogEntityOptional = dogRepository.findById(dogId);
        if(dogEntityOptional.isEmpty())
            throw new NoSuchDogException();

        DogEntity dogEntity = dogEntityOptional.get();
        return DogDto.builder()
                .id(dogEntity.getId())
                .name(dogEntity.getName())
                .age(dogEntity.getAge())
                .type(dogEntity.getType())
                .imageUrl(dogEntity.getImageUrl())
                .gender(dogEntity.getGender().name())
                .build();
    }
}
