package com.vmware.adoptionapi.adoption.internal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionRepository extends JpaRepository<AdoptionEntity, Long> {
    boolean existsByPetId_AndPetType(Long petId, PetType petType);
}
