package com.vmware.adoptionapi.adoption;

import com.vmware.adoptionapi.adoption.internal.PetType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdoptionRequest {
    private Long petId;
    private PetType petType;
    private String ownerName;
}
