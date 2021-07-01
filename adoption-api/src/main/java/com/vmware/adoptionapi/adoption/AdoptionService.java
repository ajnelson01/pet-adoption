package com.vmware.adoptionapi.adoption;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.vmware.adoptionapi.adoption.internal.AdoptionEntity;
import com.vmware.adoptionapi.adoption.internal.AdoptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptionService {
    private final AdoptionRepository adoptionRepository;
    private final RestTemplate restTemplate;
    private final EurekaClient discoveryClient;

    public AdoptionService(AdoptionRepository adoptionRepository,
                           RestTemplate restTemplate,
                           EurekaClient discoveryClient) {
        this.adoptionRepository = adoptionRepository;
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    public List<AdoptionDto> getAdoptions() {
        List<AdoptionEntity> adoptions = adoptionRepository.findAll();
        return adoptions.stream().map(adoptionEntity -> AdoptionDto.builder()
                .petId(adoptionEntity.getPetId())
                .petType(adoptionEntity.getPetType().name())
                .ownerName(adoptionEntity.getOwnerName())
                .build()).collect(Collectors.toList());
    }

    public Long adopt(AdoptionRequest adoptionRequest) {
        boolean isPetValid = false;
        switch (adoptionRequest.getPetType()) {
            case CAT:
                isPetValid = isCatValid(adoptionRequest.getPetId());
                break;
            case DOG:
                isPetValid = isDogValid(adoptionRequest.getPetId());
                break;
        }
        if (!isPetValid)
            throw new NoSuchPetException(String.format("No %s with id %d found", adoptionRequest.getPetType().name(), adoptionRequest.getPetId()));

        if (adoptionRepository.existsByPetId_AndPetType(adoptionRequest.getPetId(), adoptionRequest.getPetType()))
            throw new AlreadyAdoptedException("This pet has already been adopted");

        AdoptionEntity adoptionEntity = AdoptionEntity.builder()
                .ownerName(adoptionRequest.getOwnerName())
                .petId(adoptionRequest.getPetId())
                .petType(adoptionRequest.getPetType())
                .build();

        adoptionRepository.save(adoptionEntity);

        return adoptionEntity.getId();
    }

    private Boolean isCatValid(Long catId) {
        try {
            restTemplate.getForEntity(getServiceUrl("cat-api") + "/api/cats/" + catId, String.class);
            return true;
        }
        catch (final HttpClientErrorException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private Boolean isDogValid(Long dogId) {
        try {
            restTemplate.getForEntity(getServiceUrl("dog-api") + "/api/dogs/" + dogId, String.class);
            return true;
        }
        catch (final HttpClientErrorException e) {
            return false;
        }
    }

    private String getServiceUrl(String serviceName) {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka(serviceName, false);
        return instance.getHomePageUrl();
    }
}
