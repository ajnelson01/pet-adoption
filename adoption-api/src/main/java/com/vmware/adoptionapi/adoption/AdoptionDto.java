package com.vmware.adoptionapi.adoption;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AdoptionDto {
    private Long petId;
    private String petType;
    private String ownerName;
}
